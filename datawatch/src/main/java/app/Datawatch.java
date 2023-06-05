/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import config.log.Log;
import config.log.LogEntrada;
import config.log.LogInsert;
import config.slack.ConexaoSlack;
import config.slack.SlackEnum;
import static config.slack.SlackEnumController.logMessage;
import java.io.IOException;
import java.util.Scanner;
import model.Capturas;
import model.Maquinas;
import model.Usuarios;
import org.json.JSONObject;
import service.CapturasService;
import service.LogService;
import service.MaquinasService;
import service.RebootService;
import service.UsuariosService;

/**
 *
 * @author victor
 */
public class Datawatch {

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scnr = new Scanner(System.in);
        Boolean isLoggedIn = false;
        JSONObject json = new JSONObject();


        Usuarios usuario = null;
        Maquinas maquina = null;
        Capturas captura = new Capturas();

        // Enquanto não for autenticado (credenciais corretas com o banco),
        // pede para digitar login e senha.
        // Caso consiga logar, atribui ao objeto usuario os valores respectivos do banco.
        // Envia uma mensagem no Slack de LOGIN.
        // Cria um log de login.
        // Caso as informações de login estejam inválidas,
        // envia uma mensagem no Slack de LOGIN_FALHO.
        while (!isLoggedIn) {
            System.out.println("Login:");
            String login = scnr.nextLine();
            System.out.println("Senha:");
            String senha = scnr.nextLine();

            usuario = UsuariosService.login(login, senha);
            if (usuario != null) {
                isLoggedIn = true;

                ConexaoSlack.sendMessage(json.put("text", logMessage(SlackEnum.INFO_LOGIN)));

                Log logEntrada = new LogEntrada(senha, usuario.getNomeUsuario(), senha);
                logEntrada.criarLog();
                
                System.out.println(String.format("Usuário %s logado com sucesso!", usuario.getNomeUsuario()));
            } else {
                ConexaoSlack.sendMessage(json.put("text", logMessage(SlackEnum.WARNING_LOGIN_FALHO)));
                System.out.println("Informações de login ou senha fornecidas inválidas.\n");
            }
        }

        // Se o login foi realizado com sucesso
        // verifica se existe esta máquina no banco.
        // Se existe, altera o valor do objeto maquina para a do banco.
        // Verifica se não existe (resultado da query do banco foi null).
        // Se não existe, define os dados da máquina para capturas do Looca,
        // atribui a ela a fkEmpresa do usuario logado
        // e insere a maquina nova no banco.
        // Se existe, update na tabela do banco com dados novos da máquina.
        if (isLoggedIn) {
            maquina = MaquinasService.getMaquinaAzure();
            if (maquina == null) {
                maquina = MaquinasService.setMaquina();
                maquina.setFkEmpresa(usuario.getFkEmpresa());
                MaquinasService.insertMaquinaAzure(maquina);
                MaquinasService.insertMaquinaMySQL(maquina);
                RebootService.insertReboot(maquina.getIdMaquina(), maquina.getFkEmpresa());
            } else {
                maquina = MaquinasService.updateMaquinaAzure(maquina);
                MaquinasService.updateMaquinaMySQL(maquina);
            }
            
            // Setando ID maquina e FK empresa para as capturas
            captura.setFkEmpresa(maquina.getFkEmpresa());
            captura.setFkMaquina(maquina.getIdMaquina());
            
            // Instanciando o objeto do Log de insert
            Log logInsert =  new LogInsert("", maquina.getNomeMaquina(), "");
            
            // Loop da captura dos dados
            while (true) {
                CapturasService.setCaptura(captura);
                CapturasService.insertCapturaAzure(captura);
                CapturasService.insertCapturaMySQL(captura);
                logInsert.criarLog();

                LogService.criarAlerta(maquina);
                
                RebootService.rebootar(maquina.getIdMaquina());
                Thread.sleep(15000);
            }
        }
    }
}

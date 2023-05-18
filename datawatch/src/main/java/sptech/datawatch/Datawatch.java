package sptech.datawatch;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.util.Conversor;
import hardwares.DatawatchDiscos;
import inserts.Inserts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import org.springframework.jdbc.core.JdbcTemplate;
import tabelas.Usuarios;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;
import javax.swing.Timer;
import login.Sha2_256;
import login.TelaLogin;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import selects.Selects;
import tabelas.Capturas;
import tabelas.Empresas;
import tabelas.Maquinas;

public class Datawatch {

    public static void main(String[] args) throws IOException, InterruptedException {
        Sha2_256 hash = new Sha2_256();
        Looca looca = new Looca();
        Conexao conexaoAzure = new Conexao("azure");
        Conexao conexaoMysql = new Conexao("mysql");
        JdbcTemplate jdbcAzure = conexaoAzure.getConnection();
        JdbcTemplate jdbcMysql = conexaoMysql.getConnection();
        Scanner scnr = new Scanner(System.in);
        Boolean autenticado = false;
        Integer fkEmpresa = 0;

        // VERIFICAÇÃO DA EXISTÊNCIA DESSE USUÁRIO NO BANCO
        while (!autenticado) {
            // LOGIN
            System.out.println("Digite seu login");
            String email = scnr.nextLine();
            System.out.println("Digite sua senha");
            String senha = scnr.nextLine();
            if (email != null && senha != null) {
                try {
                    senha = hash.criarHash(senha);
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println("Erro");
                }

                List<Usuarios> listaUsuarios = jdbcAzure.query("SELECT * FROM Usuarios WHERE email = ? AND senha = ?;", new BeanPropertyRowMapper(Usuarios.class), email, senha);

                if (!listaUsuarios.isEmpty()) {
                    System.out.println("Login realizado com sucesso! Conectando...");
                    System.out.println(listaUsuarios.get(0).getEmail());
                    fkEmpresa = listaUsuarios.get(0).getFkEmpresa();
                    autenticado = true;
                } else {
                    System.out.println("USUÁRIO E/OU SENHA INVÁLIDO!");
                }
            }
        }

        // SE REALIZAR O LOGIN COM SUCESSO
        if (autenticado) {
            // INSERIR DADOS NA EMPRESA NO BANCO DE DADOS DO CONTAINER
            List<Empresas> empresa = Selects.pegarEmpresa(jdbcAzure, fkEmpresa);
            if(empresa != null)
                inserts.Inserts.inserirEmpresaContainer(jdbcMysql, empresa.get(0));
            
            // VERIFICA SE ESSA MÁQUINA EXISTE NO BANCO DE DADOS
            Maquinas maquina = Selects.pegarMaquinaCorrespondente(jdbcAzure);

            if (maquina == null) {
                System.out.println("Máquina não existe. Inserindo dados no banco de dados");
                // INSERE OS DADOS ESTÁTICOS DA MÁQUINA NO BD CASO NÃO EXISTA
                inserts.Inserts.inserirDadosMaquinaEstatico(jdbcAzure, jdbcMysql, looca, fkEmpresa, null, false);
            } else {
                System.out.println("Máquina já existe\n");
                Integer idMaquina = maquina.getIdMaquina();
                // UPDATE NOS DADOS ESTÁTICOS DA MÁQUINA NO BD CASO EXISTA
                inserts.Inserts.inserirDadosMaquinaEstatico(jdbcAzure, jdbcMysql, looca, null, idMaquina, true);
            }

            // LOOP PARA CAPTURAR DADOS VOLÁTEIS
            while (true) {
                // RETORNA OS DADOS DO BD DESTA MÁQUINA
                maquina = Selects.pegarMaquinaCorrespondente(jdbcAzure);

                // INSERE UMA CAPTURA PARA OS DADOS VOLÁTEIS DESTA MÁQUINA
                inserts.Inserts.capturarInserirDados(maquina.getIdMaquina(), maquina.getFkEmpresa(), jdbcAzure, jdbcMysql);
                
                // VERIFICA SE O COMANDO PARA REBOOTAR A MÁQUINA FOI ATIVADO
                if (Selects.reebotar(jdbcAzure, maquina.getIdMaquina(), maquina.getFkEmpresa())) {
                    RebootOld.rebootar();
                }
                // DELAY DE 5s PARA CONTINUAR O LAÇO DE REPETIÇÃO
                Thread.sleep(5000);
            }
        }

        // verificando se a máquina já existe no banco de dados através do endereço MAC
//        Maquinas maquina = Selects.pegarMaquinaCorrespondente(jdbcAzure);
//        
//        // AQUI A GENTE CRIA CONEXAO COM O BANCO DE DADOS 
//        // CONFIGURADO NO CONEXAO.JAVA
//        Conexao conexaoAzure = new Conexao("azure");
//        Conexao conexaoMysql = new Conexao("mysql");
//        
//        // ESSE CON SEMPRE VAMOS USAR PRA DAR COMANDOS NO BANCO
//        JdbcTemplate conAzure = conexaoAzure.getConnection();
//        JdbcTemplate conMysql = conexaoMysql.getConnection();
//        
//        // AQUI PEGA O ENDEREÇO DE CONEXAO E USA O TEMPLATE PRA ACESSAR
//        conexaoAzure.getConnection();
//        conexaoMysql.getConnection();
//
//        //LOOCA API
//        Looca looca = new Looca();
//
//        DatawatchDiscos discosMaquina = new DatawatchDiscos();
//        discosMaquina.inserirDiscos();
//
//        Memoria ram = looca.getMemoria();
//
//        Processador cpu = looca.getProcessador();
//
//        Rede rede = looca.getRede();
//
//        Volume volume = looca.getGrupoDeDiscos().getVolumes().get(0);
//
//        List<RedeInterface> ri = rede.getGrupoDeInterfaces().getInterfaces();
//
//        Double redeUpload = 0.0;
//        Double redeDownload = 0.0;
//
//        if (ri.size() == 1) {
//            redeUpload = Format.formatarInserirBanco(ri.get(0).getBytesEnviados());
//            redeDownload = Format.formatarInserirBanco(ri.get(0).getBytesRecebidos());
//        }
//        
//        System.out.println(looca.getGrupoDeDiscos().getDiscos().get(1).getModelo());
////        List<Capturas> capturas = conAzure.query("SELECT * FROM Capturas WHERE fkEmpresa = 1;", new BeanPropertyRowMapper(Capturas.class));
////        System.out.println(capturas);
//        Double cpuEmUso = cpu.getUso();
//        Double ramEmUso = Format.formatarInserirBanco(ram.getEmUso());
//        Double discoLivre = Format.formatarInserirBanco(volume.getDisponivel());
//           
//        System.out.println("Inserindo captura na Nuvem Azure e no MYSQL do container Docker");
//        Inserts.inserirCaptura(conAzure, conMysql, 1, 1, cpuEmUso, ramEmUso, redeUpload, redeDownload, discoLivre, null, null);
//        System.out.println("\nINSERIDO!");
//        
//        System.out.println("Dados inseridos no MYSQL do container:\n");
//        List<Capturas> capturas = conMysql.query("SELECT * FROM Capturas;", new BeanPropertyRowMapper(Capturas.class));
//        System.out.println(capturas);
//        
//        System.out.println("\nDados inseridos na Nuvem Azure\n");
//        capturas = conAzure.query("SELECT * FROM Capturas WHERE fkEmpresa = 1;", new BeanPropertyRowMapper(Capturas.class));
//        System.out.println(capturas);
//        capturas = conAzure.query("SELECT * FROM Capturas WHERE fkEmpresa = 1;", new BeanPropertyRowMapper(Capturas.class));
//        System.out.println(capturas);
    }
}

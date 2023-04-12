package sptech.datawatch;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import tabelas.Usuarios;
import login.TelaLogin;

public class Datawatch {

    public static void main(String[] args) throws IOException {
           
        // AQUI A GENTE CRIA CONEXAO COM O BANCO DE DADOS 
        // CONFIGURADO NO CONEXAO.JAVA
        Conexao conexao = new Conexao();

        // ESSE CON SEMPRE VAMOS USAR PRA DAR COMANDOS NO BANCO
        JdbcTemplate con = conexao.getConnection();

        // AQUI PEGA O ENDEREÇO DE CONEXAO E USA O TEMPLATE PRA ACESSAR
        conexao.getConnection();
        
        //LOOCA API
        Looca looca = new Looca();
        System.out.println(looca.getSistema());
        System.out.println(looca.getSistema().getInicializado());
        System.out.println(looca.getRede());
        System.out.println(looca.getProcessador().getFrequencia());
        
        
        
        // CONVERSOR
        System.out.println(
        Conversor.formatarBytes(looca.getGrupoDeDiscos().getTamanhoTotal()));
        System.out.println("Sem conversor:");
        System.out.println(looca.getGrupoDeDiscos().getTamanhoTotal());
        System.out.println(
        Conversor.formatarBytes(looca.getMemoria().getTotal()));
        System.out.println(
        Conversor.formatarBytes(looca.getProcessador().getFrequencia()));
        
        //MAC e IP
        Mac mac = new Mac();
        System.out.printf("MAC: %s", mac.getMac());
        
        Ip ip = new Ip();
        System.out.printf("\nIP: %s",ip.getIp());
        
        //REBOOT
        Reboot re = new Reboot();
        //re.rebootar(ip.getIp());
    }
}

package sptech.datawatch;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import tabelas.Usuarios;
import login.TelaLogin;
import java.time.Instant;

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
        
        //REDE
        System.out.println("REDE AQUI:");
        System.out.println(looca.getRede().getGrupoDeInterfaces());
        System.out.println(looca.getRede().getParametros());
        for (int i = 0; i < looca.getRede().getGrupoDeInterfaces().getInterfaces().size(); i++) {
            
        System.out.println(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(i).getEnderecoIpv4());
        }
        
        
        //PROCESSADOR
        System.out.println("PROCESSADOR AQUI:");
        System.out.println(looca.getProcessador().getFrequencia());
        System.out.println(looca.getProcessador().getIdentificador());
        System.out.println(looca.getProcessador());
        
        // MEMORIA RAM
        System.out.println(looca.getMemoria());
        
        // DISCOS DESCRITOS
        System.out.println("\nDISCOS AQUI:");
            System.out.println("Quantidade de discos:");
            System.out.println(looca.getGrupoDeDiscos().getQuantidadeDeDiscos());
            
        for (int i = 0; i < looca.getGrupoDeDiscos().getQuantidadeDeDiscos(); i++) {  
        System.out.println(looca.getGrupoDeDiscos().getDiscos().get(i));
        }
        
        
        // CONVERSOR
        System.out.println(
        Conversor.formatarBytes(looca.getGrupoDeDiscos().getTamanhoTotal()));
        System.out.println("Sem conversor:");
        System.out.println(looca.getGrupoDeDiscos().getTamanhoTotal());
        System.out.println(
        Conversor.formatarBytes(looca.getMemoria().getTotal()));
        System.out.println(
        Conversor.formatarBytes(looca.getProcessador().getFrequencia()));
        System.out.println(
        Conversor.formatarSegundosDecorridos(looca.getSistema().getTempoDeAtividade()));
        System.out.println(looca.getSistema().getTempoDeAtividade());
        
        //MAC e IP
        Mac mac = new Mac();
        System.out.printf("MAC: %s", mac.getMac());
        
        Ip ip = new Ip();
        System.out.printf("\nIP: %s",ip.getIp());
        
        //REBOOT
        Reboot re = new Reboot();
        //re.rebootar("10.0.0.108");
        
      
    }
}

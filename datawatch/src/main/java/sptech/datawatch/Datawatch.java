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
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import tabelas.Usuarios;
import login.TelaLogin;
import java.time.Instant;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import tabelas.Capturas;
import tabelas.Maquinas;

public class Datawatch {

    public static void main(String[] args) throws IOException {

        // AQUI A GENTE CRIA CONEXAO COM O BANCO DE DADOS 
        // CONFIGURADO NO CONEXAO.JAVA
        Conexao conexaoAzure = new Conexao("azure");
        Conexao conexaoMysql = new Conexao("mysql");
        
        // ESSE CON SEMPRE VAMOS USAR PRA DAR COMANDOS NO BANCO
        JdbcTemplate conAzure = conexaoAzure.getConnection();
        JdbcTemplate conMysql = conexaoMysql.getConnection();
        
        // AQUI PEGA O ENDEREÇO DE CONEXAO E USA O TEMPLATE PRA ACESSAR
        conexaoAzure.getConnection();
        conexaoMysql.getConnection();

        //LOOCA API
        Looca looca = new Looca();

        DatawatchDiscos discosMaquina = new DatawatchDiscos();
        discosMaquina.inserirDiscos();

        Memoria ram = looca.getMemoria();

        Processador cpu = looca.getProcessador();

        Rede rede = looca.getRede();

        Volume volume = looca.getGrupoDeDiscos().getVolumes().get(0);

        List<RedeInterface> ri = rede.getGrupoDeInterfaces().getInterfaces();

        Double redeUpload = 0.0;
        Double redeDownload = 0.0;

        if (ri.size() == 1) {
            redeUpload = Format.formatarInserirBanco(ri.get(0).getBytesEnviados());
            redeDownload = Format.formatarInserirBanco(ri.get(0).getBytesRecebidos());
        }  
        
//        List<Capturas> capturas = conAzure.query("SELECT * FROM Capturas WHERE fkEmpresa = 1;", new BeanPropertyRowMapper(Capturas.class));
//        System.out.println(capturas);
        Double cpuEmUso = cpu.getUso();
        Double ramEmUso = Format.formatarInserirBanco(ram.getEmUso());
        Double discoLivre = Format.formatarInserirBanco(volume.getDisponivel());
           
        System.out.println("Inserindo captura na Nuvem Azure e no MYSQL do container Docker");
        Inserts.inserirCaptura(conAzure, conMysql, 1, 1, cpuEmUso, ramEmUso, redeUpload, redeDownload, discoLivre, null, null);
        System.out.println("\nINSERIDO!");
        
        System.out.println("Dados inseridos no MYSQL do container:\n");
        List<Capturas> capturas = conMysql.query("SELECT * FROM Capturas;", new BeanPropertyRowMapper(Capturas.class));
        System.out.println(capturas);
        
        System.out.println("\nDados inseridos na Nuvem Azure\n");
        capturas = conAzure.query("SELECT * FROM Capturas WHERE fkEmpresa = 1;", new BeanPropertyRowMapper(Capturas.class));
        System.out.println(capturas);
//        capturas = conAzure.query("SELECT * FROM Capturas WHERE fkEmpresa = 1;", new BeanPropertyRowMapper(Capturas.class));
//        System.out.println(capturas);
    }
}

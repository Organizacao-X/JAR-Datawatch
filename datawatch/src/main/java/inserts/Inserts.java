/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inserts;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.util.Conversor;
import hardwares.DatawatchDiscos;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import sptech.datawatch.Format;
import sptech.datawatch.Ip;

/**
 *
 * @author victor
 */
public class Inserts {
    
    public static void inserirCaptura(JdbcTemplate conAzure, JdbcTemplate conMysql, Integer fkMaquina, Integer fkEmpresa, Double cpuUso,
            Double ramUso, Double redeUpload, Double redeDownload, Double discoLivre, Double discoLivre2, Double discoLivre3) {
        if (fkMaquina == null || fkEmpresa == null || cpuUso == null || ramUso == null || redeUpload == null || redeDownload == null || discoLivre == null) {
            System.out.println("Dados inválidos. Não foi possível realizar o INSERT");
        } else {
            conMysql.update("INSERT INTO Capturas (idCaptura, fkMaquina, fkEmpresa, dataHora, cpuUso, temperatura, ramUso, redeUpload, redeDownload, LivreDisco1, LivreDisco2, LivreDisco3) VALUES"
                    + "(null, ?, ?, CURRENT_TIMESTAMP, TRUNCATE(?, 2), 42.0, ?, ?, ?, ?, null, null)", fkMaquina, fkEmpresa, cpuUso, ramUso, redeUpload, redeDownload, discoLivre);
            conAzure.update("INSERT INTO Capturas (fkMaquina, fkEmpresa, dataHora, cpuUso, temperatura, ramUso, redeUpload, redeDownload, LivreDisco1, LivreDisco2, LivreDisco3) VALUES"
                    + "(?, ?, CURRENT_TIMESTAMP, CAST(ROUND(?, 2, 1) AS FLOAT), 42.0, ?, ?, ?, ?, null, null)", fkMaquina, fkEmpresa, cpuUso, ramUso, redeUpload, redeDownload, discoLivre);
        }
    }

    public static void inserirDadosMaquinaEstatico(JdbcTemplate conAzure, JdbcTemplate conMysql, Looca looca) {

        // DADOS MAQUINA
        Integer fkEmpresa = 1;
        String serie = "ABCD1";
        String dtChegada;
        
        // DADOS DISCOS
        DatawatchDiscos discosMaquina = new DatawatchDiscos();
        discosMaquina.inserirDiscos();
        // NOMES DISCOS
        String nomeDisco1 = discosMaquina.discos.get(0).getNome();
        String nomeDisco2 = discosMaquina.discos.get(1) == null ? null : discosMaquina.discos.get(1).getNome();
        String nomeDisco3 = discosMaquina.discos.get(2) == null ? null : discosMaquina.discos.get(2).getNome();
        // TOTAL DISCOS
        Double totalDisco1 = Format.formatarInserirBanco(discosMaquina.discos.get(0).getTamanho());
        Double totalDisco2 = discosMaquina.discos.get(1) == null ? null : Format.formatarInserirBanco(discosMaquina.discos.get(1).getTamanho());
        Double totalDisco3 = discosMaquina.discos.get(2) == null ? null : Format.formatarInserirBanco(discosMaquina.discos.get(2).getTamanho());
        // GATILHO DISCOS
        Double gatilhoDisco1 = null;
        Double gatilhoDisco2 = null;
        Double gatilhoDisco3 = null;

        // DADOS SISTEMA
        String nomeMaquina = looca.getRede().getParametros().getHostName();
        String sistemaOperacional = looca.getSistema().getSistemaOperacional();
        String ip = Ip.getIp();
        Integer tempoAtividade = Integer.valueOf(looca.getSistema().getTempoDeAtividade() + "");
        Integer statusSistema = 1;
        
        // CPU
        String processador = looca.getProcessador().getNome();
        Double cpuFrequencia = looca.getProcessador().getFrequencia() / Math.pow(10, 9);
        Double cpuMetrica = null;
        
        // RAM
        String ram = "n tem como pegar nome";
        Double ramTotal = Format.formatarInserirBanco(looca.getMemoria().getTotal());
        Double ramMetrica = null;
        
        
//        System.out.println(fkEmpresa);
//        System.out.println(serie);
//        System.out.println(nomeDisco1);
//        System.out.println(nomeDisco2);
//        System.out.println(nomeDisco3);
//        System.out.println(totalDisco1);
//        System.out.println(totalDisco2);
//        System.out.println(totalDisco3);
//        System.out.println(gatilhoDisco1);
//        System.out.println(gatilhoDisco2);
//        System.out.println(gatilhoDisco3);
//        System.out.println(nomeMaquina);
//        System.out.println(sistemaOperacional);
//        System.out.println(ip);
//        System.out.println(statusSistema);
//        System.out.println(processador);
//        System.out.println(cpuFrequencia);
//        System.out.println(cpuMetrica);
//        System.out.println(ram);
//        System.out.println(ramTotal);
//        System.out.println(ramMetrica);
//        System.out.println(tempoAtividade);
        
//        conAzure.update("INSERT INTO Maquinas ("
//                + "fkEmpresa, nomeMaquina, serie, dtChegada, sistemaOperacional, "
//                + "processador, ram, nomeDisco1, nomeDisco2, nomeDisco3, "
//                + "ip, statusSistema, cpuFrequencia, ramTotal, totalDisco1, "
//                + "totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1, "
//                + "gatilhoDisco2, gatilhoDisco3, tempoAtividade) VALUES"
//                + "(?, ?, ?, CURRENT_DATE, ?, "
//                + "?, ?, ?, ?, ?, "
//                + "?, ?, TRUNCATE(?, 2), ?, ?, "
//                + "?, ?, ?, ?, ?, "
//                + "?, ?, ?);",
//                fkEmpresa, nomeMaquina, serie, sistemaOperacional, processador, ram, nomeDisco1, nomeDisco2, nomeDisco3, ip, statusSistema, cpuFrequencia,
//                ramTotal, totalDisco1, totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1, gatilhoDisco2, gatilhoDisco3, tempoAtividade);
        
        conMysql.update("INSERT INTO Maquinas ("
                + "fkEmpresa, nomeMaquina, serie, dtChegada, sistemaOperacional, "
                + "processador, ram, nomeDisco1, nomeDisco2, nomeDisco3, "
                + "ip, statusSistema, cpuFrequencia, ramTotal, totalDisco1, "
                + "totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1, "
                + "gatilhoDisco2, gatilhoDisco3, tempoAtividade) VALUES"
                + "(?, ?, ?, CURRENT_DATE, ?, "
                + "?, ?, ?, ?, ?, "
                + "?, ?, TRUNCATE(?, 2), ?, ?, "
                + "?, ?, ?, ?, ?, "
                + "?, ?, ?);",
                fkEmpresa, nomeMaquina, serie, sistemaOperacional, processador, ram, nomeDisco1, nomeDisco2, nomeDisco3, ip, statusSistema, cpuFrequencia,
                ramTotal, totalDisco1, totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1, gatilhoDisco2, gatilhoDisco3, tempoAtividade);
    }
}

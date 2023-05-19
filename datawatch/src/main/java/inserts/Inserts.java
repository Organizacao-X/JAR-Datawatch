/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inserts;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import hardwares.DatawatchDiscos;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sptech.datawatch.Format;
import sptech.datawatch.Ip;
import tabelas.Empresas;
import tabelas.Maquinas;

/**
 *
 * @author victor
 */
public class Inserts {

    public static void capturarInserirDados(Integer fkMaquina, Integer fkEmpresa, JdbcTemplate conAzure, JdbcTemplate conMysql) {
        List capturas = new ArrayList();
        Looca looca = new Looca();
        List<RedeInterface> ri = looca.getRede().getGrupoDeInterfaces().getInterfaces();
        DiscoGrupo grupoDiscos = looca.getGrupoDeDiscos();
        List<Volume> listaVolumes = grupoDiscos.getVolumes();
        // cpuUso, temperatura ?, ramUso, redeUpload, redeDownload, LivreDisco1, LivreDisco2, LivreDisco3
        Double cpuUso = looca.getProcessador().getUso();
        Double ramUso = Format.formatarInserirBanco(looca.getMemoria().getEmUso());
        Double redeDownload = Format.formatarInserirBanco(ri.get(0).getBytesRecebidos());
        Double redeUpload = Format.formatarInserirBanco(ri.get(0).getBytesEnviados());
        Double LivreDisco1 = Format.formatarInserirBanco(listaVolumes.get(0).getDisponivel());
        Double LivreDisco2 = listaVolumes.get(1) == null ? null : Format.formatarInserirBanco(listaVolumes.get(1).getDisponivel());
        Double LivreDisco3 = listaVolumes.get(2) == null ? null : Format.formatarInserirBanco(listaVolumes.get(2).getDisponivel());
        capturas.add(fkMaquina);
        capturas.add(fkEmpresa);
        capturas.add(cpuUso);
        capturas.add(42.0);
        capturas.add(ramUso);
        capturas.add(redeUpload);
        capturas.add(redeDownload);
        capturas.add(LivreDisco1);
        capturas.add(LivreDisco2);
        capturas.add(LivreDisco3);
        System.out.println(capturas);
        inserirCaptura(conAzure, conMysql, fkMaquina, fkEmpresa, cpuUso, ramUso, redeUpload, redeDownload, LivreDisco3, LivreDisco2, LivreDisco3);
    }

    public static void inserirCaptura(JdbcTemplate conAzure, JdbcTemplate conMysql, Integer fkMaquina, Integer fkEmpresa, Double cpuUso,
            Double ramUso, Double redeUpload, Double redeDownload, Double LivreDisco, Double LivreDisco2, Double LivreDisco3) {
        if (fkMaquina == null || fkEmpresa == null || cpuUso == null || ramUso == null || redeUpload == null || redeDownload == null || LivreDisco == null) {
            System.out.println("Dados inválidos. Não foi possível realizar o INSERT");
        } else {
            conMysql.update("INSERT INTO Capturas (idCaptura, fkMaquina, fkEmpresa, dataHora, cpuUso, temperatura, ramUso, redeUpload, redeDownload, LivreDisco1, LivreDisco2, LivreDisco3) VALUES"
                    + "(null, ?, ?, CURRENT_TIMESTAMP, TRUNCATE(?, 2), 42.0, ?, ?, ?, ?, ?, ?)", fkMaquina, fkEmpresa, cpuUso, ramUso, redeUpload, redeDownload, LivreDisco, LivreDisco2, LivreDisco3);
            conAzure.update("INSERT INTO Capturas (fkMaquina, fkEmpresa, dataHora, cpuUso, temperatura, ramUso, redeUpload, redeDownload, LivreDisco1, LivreDisco2, LivreDisco3) VALUES"
                    + "(?, ?, CURRENT_TIMESTAMP, CAST(ROUND(?, 2, 1) AS FLOAT), 42.0, ?, ?, ?, ?, ?, ?)", fkMaquina, fkEmpresa, cpuUso, ramUso, redeUpload, redeDownload, LivreDisco, LivreDisco2, LivreDisco3);
        }
    }

    public static void inserirDadosMaquinaEstatico(JdbcTemplate conAzure, JdbcTemplate conMysql, Looca looca, Integer fkEmpresa, Integer idMaquina, Boolean update) {

        // DADOS MAQUINA
        String serie = "ABCD1";
        String dtChegada;

        // DADOS DISCOS
        DatawatchDiscos discosMaquina = new DatawatchDiscos();
        discosMaquina.inserirDiscos();
        // NOMES DISCOS
        String nomeDisco1 = discosMaquina.discos.get(0).getModelo();
        String nomeDisco2 = discosMaquina.discos.get(1) == null ? null : discosMaquina.discos.get(1).getModelo();
        String nomeDisco3 = discosMaquina.discos.get(2) == null ? null : discosMaquina.discos.get(2).getModelo();
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
        String mac = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoMac();

        // CPU
        String processador = looca.getProcessador().getNome();
        Double cpuPorcentagem = looca.getProcessador().getUso();
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
        if (!update) {
            conAzure.update("INSERT INTO Maquinas ("
                    + "fkEmpresa, nomeMaquina, serie, dtChegada, sistemaOperacional, "
                    + "processador, ram, nomeDisco1, nomeDisco2, nomeDisco3, "
                    + "ip, statusSistema, cpuPorcentagem, ramTotal, totalDisco1, "
                    + "totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1, "
                    + "gatilhoDisco2, gatilhoDisco3, tempoAtividade, mac) VALUES"
                    + "(?, ?, ?, CONVERT(DATE, GETDATE()), ?, "
                    + "?, ?, ?, ?, ?, "
                    + "?, ?, ROUND(?, 2), ?, ?, "
                    + "?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?);",
                    fkEmpresa, nomeMaquina, serie, sistemaOperacional, processador, ram, nomeDisco1, nomeDisco2, nomeDisco3, ip, statusSistema, cpuPorcentagem,
                    ramTotal, totalDisco1, totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1, gatilhoDisco2, gatilhoDisco3, tempoAtividade, mac);
            conMysql.update("INSERT INTO Maquinas ("
                    + "fkEmpresa, nomeMaquina, serie, dtChegada, sistemaOperacional, "
                    + "processador, ram, nomeDisco1, nomeDisco2, nomeDisco3, "
                    + "ip, statusSistema, cpuPorcentagem, ramTotal, totalDisco1, "
                    + "totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1, "
                    + "gatilhoDisco2, gatilhoDisco3, tempoAtividade, mac) VALUES"
                    + "(?, ?, ?, CURRENT_DATE, ?, "
                    + "?, ?, ?, ?, ?, "
                    + "?, ?, TRUNCATE(?, 2), ?, ?, "
                    + "?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?);",
                    fkEmpresa, nomeMaquina, serie, sistemaOperacional, processador, ram, nomeDisco1, nomeDisco2, nomeDisco3, ip, statusSistema, cpuPorcentagem,
                    ramTotal, totalDisco1, totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1, gatilhoDisco2, gatilhoDisco3, tempoAtividade, mac);

            List<Maquinas> estaMaquina = conAzure.query("SELECT * FROM Maquinas WHERE mac = ?", new BeanPropertyRowMapper(Maquinas.class), mac);

            conAzure.update("INSERT INTO Reboot VALUES (?, ?, 0);", estaMaquina.get(0).getIdMaquina(), fkEmpresa);
        } else {
            System.out.println("Máquina já existente. Atualizando dados estáticos da máquina");
            conAzure.update("UPDATE Maquinas SET nomeMaquina = ?, serie = ?, sistemaOperacional = ?, processador = ?, ram = ?, nomeDisco1 = ?, nomeDisco2 = ?,"
                    + "nomeDisco3 = ?, ip = ?, statusSistema = ?, cpuPorcentagem = ?, ramTotal = ?, totalDisco1 = ?, totalDisco2 = ?, totalDisco3 = ?, cpuMetrica = ?,"
                    + "ramMetrica = ?, gatilhoDisco1 = ?, gatilhoDisco2 = ?, gatilhoDisco3 = ?, tempoAtividade = ?, mac = ? WHERE idMaquina = ?", nomeMaquina, serie, sistemaOperacional, processador, ram, nomeDisco1,
                    nomeDisco2, nomeDisco3, ip, statusSistema, cpuPorcentagem, ramTotal, totalDisco1, totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1,
                    gatilhoDisco2, gatilhoDisco3, tempoAtividade, mac, idMaquina);
            conAzure.update("UPDATE Reboot SET rebootar = 0 WHERE fkMaquina = ?;", idMaquina);

        }

//        Integer teste = conMysql.update("INSERT INTO Maquinas ("
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
//        System.out.println(teste);
    }

    public static void inserirEmpresaContainer(JdbcTemplate conMysql, Empresas empresa) {
        List<Empresas> e = conMysql.query("SELECT * FROM Empresas WHERE cnpj = ?", new BeanPropertyRowMapper(Empresas.class), empresa.getCnpj());

        if (e.isEmpty()) {
            conMysql.update("INSERT INTO Empresas VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                    empresa.getIdEmpresa(), empresa.getRazaoSocial(), empresa.getCnpj(), empresa.getCep(), empresa.getLogradouro(),
                    empresa.getNumero(), empresa.getComplemento(), empresa.getBairro(), empresa.getCidade(), empresa.getEstado(), empresa.getVerificado(), null);
            System.out.println("Empresa inserida no banco de dados do container");
        }
    }
}

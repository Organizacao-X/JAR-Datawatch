/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import config.slack.ConexaoSlack;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Capturas;
import model.Maquinas;
import org.json.JSONObject;
import static config.slack.SlackEnumController.slackAlertUso;
import java.io.IOException;
import repository.LogRepository;

/**
 *
 * @author victor
 */
public class LogService {

    private static final LogRepository logRepository = new LogRepository();
    private static Integer contador = 0;
    private static JSONObject json = new JSONObject();

    public static void criarAlerta(Maquinas maquina) throws IOException, InterruptedException {
        Integer fkMaquina = maquina.getIdMaquina();
        Integer fkEmpresa = maquina.getFkEmpresa();
        Capturas captura = CapturasService.getUltimaCaptura(fkMaquina);
        LocalDateTime dataHora = captura.getDataHora();

        List<String> queryValues = new ArrayList();
        String value = "";


        if (captura.getCpuUso() == null) {
            // insert tabela alerta dado CPU não capturado
            value = String.format("(1, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
            queryValues.add(value);
            ConexaoSlack.sendMessage(json.put("text", slackAlertUso(1, maquina.getProcessador(), maquina.getNomeMaquina())));
        }

        if (captura.getCpuUso() >= maquina.getCpuMetrica()) {
            value = String.format("(10, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
            queryValues.add(value);
            ConexaoSlack.sendMessage(json.put("text", slackAlertUso(10, maquina.getProcessador(), maquina.getNomeMaquina())));
        }

        if (captura.getRamUso() == null) {
            // insert tabela alerta dado RAM não capturado
            value = String.format("(9, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
            queryValues.add(value);
            ConexaoSlack.sendMessage(json.put("text", slackAlertUso(9, null, maquina.getNomeMaquina())));
        }

        if (captura.getRamUso() >= maquina.getRamMetrica()) {
            contador++;
            if (contador == 10) {
                value = String.format("(11, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
                queryValues.add(value);
                ConexaoSlack.sendMessage(json.put("text", slackAlertUso(11, null, maquina.getNomeMaquina())));
                contador = 0;
            } else {
            }
        }

        if (captura.getLivreDisco1() == null) {
            value = String.format("(6, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
            queryValues.add(value);
            ConexaoSlack.sendMessage(json.put("text", slackAlertUso(6, maquina.getNomeDisco1(), maquina.getNomeMaquina())));
        }

        if (maquina.getTotalDisco1() - captura.getLivreDisco1() >= maquina.getGatilhoDisco1()) {
            value = String.format("(12, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
            queryValues.add(value);
            ConexaoSlack.sendMessage(json.put("text", slackAlertUso(12, maquina.getNomeDisco1(), maquina.getNomeMaquina())));
        }

        if (maquina.getTotalDisco1() - captura.getLivreDisco1() >= (maquina.getTotalDisco1() * 0.9)) {
            value = String.format("(3, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
            queryValues.add(value);
            ConexaoSlack.sendMessage(json.put("text", slackAlertUso(3, maquina.getNomeDisco1(), maquina.getNomeMaquina())));
        }

        if (maquina.getTotalDisco1() - captura.getLivreDisco1() >= (maquina.getTotalDisco1() * 0.98)) {
            value = String.format("(5, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
            queryValues.add(value);
            ConexaoSlack.sendMessage(json.put("text", slackAlertUso(5, maquina.getNomeDisco1(), maquina.getNomeMaquina())));
        }

        if (maquina.getNomeDisco2() != null) {
            if (captura.getLivreDisco2() == null) {
                value = String.format("(6, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
                queryValues.add(value);
                ConexaoSlack.sendMessage(json.put("text", slackAlertUso(6, maquina.getNomeDisco2(), maquina.getNomeMaquina())));
            }

            if (maquina.getTotalDisco2() - captura.getLivreDisco2() >= maquina.getGatilhoDisco2()) {
                value = String.format("(12, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
                queryValues.add(value);
                ConexaoSlack.sendMessage(json.put("text", slackAlertUso(12, maquina.getNomeDisco2(), maquina.getNomeMaquina())));
            }

            if (maquina.getTotalDisco2() - captura.getLivreDisco2() >= (maquina.getTotalDisco2() * 0.9)) {
                value = String.format("(3, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
                queryValues.add(value);
                ConexaoSlack.sendMessage(json.put("text", slackAlertUso(3, maquina.getNomeDisco2(), maquina.getNomeMaquina())));
            }
            if (maquina.getTotalDisco2() - captura.getLivreDisco2() >= (maquina.getTotalDisco2() * 0.98)) {
                value = String.format("(5, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
                queryValues.add(value);
                ConexaoSlack.sendMessage(json.put("text", slackAlertUso(5, maquina.getNomeDisco2(), maquina.getNomeMaquina())));
            }
        }

        if (maquina.getNomeDisco3() != null) {
            if (captura.getLivreDisco3() == null) {
                value = String.format("(6, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
                queryValues.add(value);
                ConexaoSlack.sendMessage(json.put("text", slackAlertUso(6, maquina.getNomeDisco3(), maquina.getNomeMaquina())));
            }

            if (maquina.getTotalDisco3() - captura.getLivreDisco3() >= maquina.getGatilhoDisco3()) {
                value = String.format("(12, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
                queryValues.add(value);
                ConexaoSlack.sendMessage(json.put("text", slackAlertUso(12, maquina.getNomeDisco3(), maquina.getNomeMaquina())));
            }

            if (maquina.getTotalDisco3() - captura.getLivreDisco3() >= (maquina.getTotalDisco3() * 0.9)) {
                value = String.format("(3, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
                queryValues.add(value);
                ConexaoSlack.sendMessage(json.put("text", slackAlertUso(3, maquina.getNomeDisco3(), maquina.getNomeMaquina())));
            }

            if (maquina.getTotalDisco3() - captura.getLivreDisco3() >= (maquina.getTotalDisco3() * 0.98)) {
                value = String.format("(5, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
                queryValues.add(value);
                ConexaoSlack.sendMessage(json.put("text", slackAlertUso(5, maquina.getNomeDisco3(), maquina.getNomeMaquina())));
            }
        }

        if (captura.getRedeDownload() == null && captura.getRedeUpload() == null) {
            value = String.format("(8, %d, %d, '%s')", fkMaquina, fkEmpresa, dataHora);
            queryValues.add(value);
            ConexaoSlack.sendMessage(json.put("text", slackAlertUso(8, null, maquina.getNomeMaquina())));
        }

        String values = queryValues.toString().replaceAll("\\[|\\]", "");
        if (!values.isBlank()) {
            logRepository.insertLog(values + ";");
        }
    }
}

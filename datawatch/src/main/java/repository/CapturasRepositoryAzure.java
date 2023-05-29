/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.ConexaoAzure;
import java.util.List;
import model.Capturas;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author victor
 */
public class CapturasRepositoryAzure {

    private static final JdbcTemplate jdbcAzure = new ConexaoAzure().getConnection();

    public void insertCaptura(Capturas captura) {
        String query = "INSERT INTO Capturas "
                + "(fkMaquina, fkEmpresa, dataHora, cpuUso, temperatura, ramUso, redeUpload,"
                + "redeDownload, LivreDisco1, LivreDisco2, LivreDisco3) VALUES"
                + "(?, ?, ?, CAST(ROUND(?, 2, 1) AS FLOAT), ?, ?, ?, ?, ?, ?, ?);";

        jdbcAzure.update(query,
                captura.getFkMaquina(),
                captura.getFkEmpresa(),
                captura.getDataHora(),
                captura.getCpuUso(),
                captura.getTemperatura(),
                captura.getRamUso(),
                captura.getRedeUpload(),
                captura.getRedeDownload(),
                captura.getLivreDisco1(),
                captura.getLivreDisco2(),
                captura.getLivreDisco3());
    }

    public Capturas getUltimaCaptura(Integer fkMaquina) {
        String query = "SELECT TOP 1 * FROM Capturas WHERE fkMaquina = ? ORDER BY idCaptura DESC;";
        List<Capturas> captura = jdbcAzure.query(query, new BeanPropertyRowMapper(Capturas.class), fkMaquina);
        if (!captura.isEmpty()) {
            return captura.get(0);
        }
        return null;
    }
}

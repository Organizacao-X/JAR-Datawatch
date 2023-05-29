/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.ConexaoMySQL;
import model.Capturas;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author victor
 */
public class CapturasRepositoryMySQL {
    
    private static final JdbcTemplate jdbcMySQL = new ConexaoMySQL().getConnection();
    
    public void insertCaptura(Capturas captura) {
        String query = "INSERT INTO Capturas "
                + "(fkMaquina, fkEmpresa, dataHora, cpuUso, temperatura, ramUso, redeUpload,"
                + "redeDownload, LivreDisco1, LivreDisco2, LivreDisco3) VALUES"
                + "(?, ?, ?, ROUND(?, 2), ?, ?, ?, ?, ?, ?, ?);";
        
        jdbcMySQL.update(query,
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
}

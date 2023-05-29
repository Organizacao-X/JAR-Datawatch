/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.ConexaoAzure;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author victor
 */
public class RebootRepository {
    
    private static final JdbcTemplate jdbcAzure = new ConexaoAzure().getConnection();
    
    public Integer getReboot(Integer fkMaquina) {
        String sql = "SELECT rebootar FROM Reboot WHERE fkMaquina = ?";
        Integer reboot = jdbcAzure.queryForObject(sql, Integer.class, fkMaquina);
        return reboot;
    }
    
    public void insertReboot(Integer fkMaquina, Integer fkEmpresa) {
        String sql = "INSERT INTO Reboot (fkMaquina, fkEmpresa, rebootar) VALUES (?, ?, 0);";
        jdbcAzure.update(sql, fkMaquina, fkEmpresa);
    }
    
    public void updateReboot(Integer fkMaquina) {
        String sql = "UPDATE Reboot SET rebootar = 0 WHERE fkMaquina = ?;";
        jdbcAzure.update(sql, fkMaquina);
    }
    
    public void rebootar() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("shutdown -r now");

        try {
            int codigoDeSaida = process.waitFor();
            System.out.println("Código de saída: " + codigoDeSaida);
        } catch (InterruptedException e) {
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.ConexaoAzure;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author victor
 */
public class LogRepository {
    
    private static final JdbcTemplate jdbcAzure = new ConexaoAzure().getConnection();
    
    public void insertLog(String values) {
        String query = "INSERT INTO Log (fkAlerta, fkMaquina, fkEmpresa, dataHora) VALUES " + values;
        jdbcAzure.update(query);
    }
}

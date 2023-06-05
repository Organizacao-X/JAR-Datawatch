/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author victor
 */
public class ConexaoMySQL {
    private JdbcTemplate connection;
    
    public ConexaoMySQL() {
        BasicDataSource dataSource = new BasicDataSource();
        
        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
            // 172.17.0.2
            dataSource​.setUrl("jdbc:mysql://172.17.0.2:3306/datawatch?serverTimezone=UTC&autoReconnect=true&useSSL=false");
            dataSource​.setUsername("root");
            dataSource​.setPassword("datawatch");
        
        this.connection = new JdbcTemplate(dataSource);
    }
    
    public JdbcTemplate getConnection() {
        return connection;
    }
}

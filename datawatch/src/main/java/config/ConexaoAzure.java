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
public class ConexaoAzure {
    private JdbcTemplate connection;
    
    public ConexaoAzure() {
        BasicDataSource dataSource = new BasicDataSource();
        
        dataSource​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource​.setUrl("jdbc:sqlserver://projetodatawatch.database.windows.net:1433;database=Datawatch;encryp\n"
                    + "t=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
            dataSource​.setUsername("cliente");
            dataSource​.setPassword("#Gfgrupo10");
            
        this.connection = new JdbcTemplate(dataSource);
    }
    
    public JdbcTemplate getConnection() {
        return connection;
    }
}

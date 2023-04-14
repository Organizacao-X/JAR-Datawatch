package sptech.datawatch;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Conexao {
    
    private JdbcTemplate connection;

    public Conexao() {
        
        BasicDataSource dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://localhost:3306/datawatch?serverTimezone=UTC");
        dataSource​.setUsername("root");
        dataSource​.setPassword("Almanaque2023!");

        this.connection = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
    
    
}

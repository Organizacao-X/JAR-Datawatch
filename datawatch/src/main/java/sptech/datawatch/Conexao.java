package sptech.datawatch;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Conexao {

    private JdbcTemplate connection;

    public Conexao() {

        BasicDataSource dataSource = new BasicDataSource();

//        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource​.setUrl("jdbc:mysql://localhost:3306/datawatch?serverTimezone=UTC");
//        dataSource​.setUsername("datawatch");
//        dataSource​.setPassword("datawatch");
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

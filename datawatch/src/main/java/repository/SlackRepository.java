package repository;

import config.ConexaoAzure;
import java.util.List;
import model.Slack;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SlackRepository {
    private static JdbcTemplate jdbcAzure = new ConexaoAzure().getConnection();
    
    public static Slack obterWebhook() {
        List<Slack> slackBanco = jdbcAzure.query("SELECT * FROM Slack WHERE id = ?;", new BeanPropertyRowMapper(Slack.class), 1);
        if (!slackBanco.isEmpty()) {
            return slackBanco.get(0);
        }
        return null;
    }
}

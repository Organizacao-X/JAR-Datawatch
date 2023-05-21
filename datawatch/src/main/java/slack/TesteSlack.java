package slack;
import java.io.IOException;
import org.json.JSONObject;
import static slack.SlackEnumController.logMessage;

public class TesteSlack {
    public static void main(String[] args) throws IOException, InterruptedException {
        JSONObject json = new JSONObject();

        Slack.sendMessage(json.put("text", logMessage(SlackEnum.INFO_LOGIN)));
        
        Slack.sendMessage(json.put("text", logMessage(SlackEnum.WARNING_LOGIN_FALHO)));
        
        json.put("text", logMessage(SlackEnum.ERROR));
        Slack.sendMessage(json);
        
        json.put("text", logMessage(SlackEnum.DEBBUG));
        Slack.sendMessage(json);
    }
}
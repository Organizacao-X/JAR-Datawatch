package config.slack;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import repository.SlackRepository;
import model.Slack;

public class ConexaoSlack {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Slack slack = SlackRepository.obterWebhook();

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(slack.getWebhook()))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            System.out.println("Erro na conexão do Slack");
        }
//        System.out.println(String.format("Status: %s", response.statusCode()));
//        System.out.println(String.format("Response: %s", response.body()));
    }


}


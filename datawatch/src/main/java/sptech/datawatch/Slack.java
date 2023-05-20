package sptech.datawatch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import tabelas.Maquinas;

public class Slack {

    private static HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }

    public void avisoLogin(Maquinas maquina) throws IOException, InterruptedException {

        JSONObject json = new JSONObject();

        Slack slack = new Slack();
        json.put("text", String.format("Maquina %s logou agora", maquina.getNomeMaquina()));
        slack.sendMessage(json);

    }
}

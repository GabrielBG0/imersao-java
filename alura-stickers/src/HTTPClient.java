import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HTTPClient {
    public String buscaDados(String url) {

        try {
            URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> respose = client.send(request, BodyHandlers.ofString());
            return respose.body();

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

    }
}

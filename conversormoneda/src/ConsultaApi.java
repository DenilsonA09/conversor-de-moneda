import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Moneda consultaMoneda(double valor, String convertido, String aConvertir) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c9333b7c53cb5745e580a3f7/pair/" + convertido + "/" + aConvertir + "/" + valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré el valor.");
        }
    }
}

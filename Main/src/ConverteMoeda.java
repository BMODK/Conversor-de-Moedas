import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverteMoeda {

    public static double Conversor(String moedaBase, String moedaAlvo) {
        // Substitua pela sua chave da API
        String endereco = "https://v6.exchangerate-api.com/v6/be6697096441f81ce7bb6afc/latest/" + moedaBase;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // --- A MÁGICA DO GSON AQUI ---
            Gson gson = new Gson();
            Moeda dados = gson.fromJson(response.body(), Moeda.class);

            // Buscamos a moeda alvo dentro do Map 'conversion_rates'
            return dados.conversion_rates().get(moedaAlvo);

        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a taxa de conversão.");
        }
    }
}
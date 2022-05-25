import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Networking
{

    public final String CATURL = "https://api.thecatapi.com/v1/images/search";
    public final String DUCKURL = "https://random-d.uk/api/random?type=jpg";
    public final String FOXURL = "https://randomfox.ca/floof/";
    public final String DOGURL = "https://dog.ceo/api/breeds/image/random";

    public String makeRequest(String URL)
    {
        try {
            URI myUri = URI.create(URL);
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return (response.body());

        } catch (Exception e) {
            return (e.getMessage());
        }
    }

    public String parseDuck(String json)
    {
        JSONObject woo = new JSONObject(json);
        return woo.getString("url");
    }

    public String parseFox(String json)
    {
        JSONObject woo = new JSONObject(json);
        return woo.getString("image");
    }

    public String parseDog(String json)
    {
        JSONObject woo = new JSONObject(json);
        return woo.getString("message");
    }

    public String parseCat(String json)
    {
        JSONArray woo = new JSONArray(json);
        JSONObject woo2 = woo.getJSONObject(0);
        return woo2.getString("url");
    }


}
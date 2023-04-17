
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import java.io.IOException;


public class  MakeHttpCalls{
  public static void main(String[] args){
    final String API_URL = "https://jsonmock.hackerrank.com/api/countries?name=iraq";
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create(API_URL))
    .method("GET", HttpRequest.BodyPublishers.noBody())
    .build();

    
    HttpResponse<String> response = null;
    
    try{
      response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
      
    } catch (IOException e) {
       e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    JSONObject obj = new JSONObject(response.body());
    System.out.println(response.body());
   }
}
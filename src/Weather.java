import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class Weather {
    public static void apiCaller(String name){
        String apiWtr = "http://api.weatherapi.com/v1/current.json?key=08032dc2790545c392b192534240905&q=" + name +"&aqi=no";
        try {
            URL url = new URL(apiWtr);

            // Proxy p = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("http://disrct:etsps2024401@rb-proxy-ca1.bosch.com", 8080));

            HttpURLConnection weatherCon = (HttpURLConnection) url.openConnection();
            weatherCon.setRequestMethod("GET");

            int res = weatherCon.getResponseCode();
            System.out.println("Response Code: " + res);
            
            if (res == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(weatherCon.getInputStream()));
                String input;
                StringBuilder response = new StringBuilder();

                while ((input = in.readLine()) != null) {
                    response.append(input);
                }
                in.close();

                System.out.println("Response Body: " + response.toString());
            }else{
                System.out.println("Failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

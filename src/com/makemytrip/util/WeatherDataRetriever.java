package com.myapp.util;

import com.myapp.model.Weather;
import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherDataRetriever {
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";

    public Weather retrieveWeatherData(String cityName) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        try {
            String apiUrl = buildApiUrl(cityName, apiKey);
            String response = sendGetRequest(apiUrl);
            JSONObject json = new JSONObject(response);
            return parseWeatherData(json);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String buildApiUrl(String cityName, String apiKey) {
        String encodedCityName = cityName.replace(" ", "%20");
        return API_URL + "?q=" + encodedCityName + "&appid=" + apiKey + "&units=metric";
    }

    private String sendGetRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } finally {
            connection.disconnect();
        }
        return response.toString();
    }

    private Weather parseWeatherData(JSONObject json) {
        JSONObject mainData = json.getJSONObject("main");
        double temperature = mainData.getDouble("temp");
        int humidity = mainData.getInt("humidity");

        Weather weather = new Weather();
        weather.setTemperature(temperature);
        weather.setHumidity(humidity);

        // You can parse additional weather data as per your requirements

        return weather;
    }
}

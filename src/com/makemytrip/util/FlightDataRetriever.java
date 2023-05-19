package com.myapp.util;

import com.myapp.model.Destination;
import com.myapp.model.Flight;
import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FlightDataRetriever {
    private static final String API_URL = "https://api.skypicker.com/flights";

    public List<Flight> retrieveFlights(Destination destination) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("KIWI_API_KEY");

        try {
            String apiUrl = buildApiUrl(destination, apiKey);
            String response = sendGetRequest(apiUrl);
            JSONArray flightsArray = new JSONObject(response).getJSONArray("data");
            return parseFlights(flightsArray);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private String buildApiUrl(Destination destination, String apiKey) {
        String encodedDestination = destination.getName().replace(" ", "%20");
        return API_URL + "?fly_from=your_location&fly_to=" + encodedDestination + "&api_key=" + apiKey;
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

    private List<Flight> parseFlights(JSONArray flightsArray) {
        List<Flight> flights = new ArrayList<>();

        for (int i = 0; i < flightsArray.length(); i++) {
            JSONObject flightObject = flightsArray.getJSONObject(i);
            Flight flight = new Flight();
            flight.setSource(flightObject.getString("flyFrom"));
            flight.setDestination(flightObject.getString("flyTo"));
            flight.setDepartureDate(flightObject.getString("dTime"));
            flight.setPrice(flightObject.getDouble("price"));
            // Parse other flight details as needed
            flights.add(flight);
        }

        return flights;
    }
}

package com.myapp.util;

import com.myapp.model.Destination;
import com.myapp.model.Expense;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class OpenTripMapDataRetriever {
    private static final String API_BASE_URL = "https://api.opentripmap.com/0.1/";

    public List<Expense> getExpensesForDestination(Destination destination) {
        List<Expense> expenses = new ArrayList<>();
        String apiKey = System.getenv("OPENTRIPMAP_API_KEY");

        try {
            String apiUrl = API_BASE_URL + "costs?geoname=" + destination.getName() + "&apikey=" + apiKey;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray expenseArray = jsonResponse.getJSONArray("expenses");
                for (int i = 0; i < expenseArray.length(); i++) {
                    JSONObject expenseObject = expenseArray.getJSONObject(i);
                    String name = expenseObject.getString("name");
                    double cost = expenseObject.getDouble("cost");
                    Expense expense = new Expense(name, cost);
                    expenses.add(expense);
                }
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return expenses;
    }
}

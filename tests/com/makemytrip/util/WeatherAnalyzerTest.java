package com.myapp.util;

import com.myapp.model.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class WeatherAnalyzerTest {
    @Test
    public void testFilterByTemperatureRange() {
        // Create test weather data
        Weather weather1 = new Weather("London", 20);
        Weather weather2 = new Weather("Paris", 25);
        Weather weather3 = new Weather("New York", 15);
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather1);
        weatherList.add(weather2);
        weatherList.add(weather3);

        // Filter weather data by temperature range (e.g., 18 to 22 degrees)
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer();
        List<Weather> filteredWeatherList = weatherAnalyzer.filterByTemperatureRange(weatherList, 18, 22);

        // Verify the filtering
        Assertions.assertEquals(2, filteredWeatherList.size());
        Assertions.assertTrue(filteredWeatherList.contains(weather1));
        Assertions.assertTrue(filteredWeatherList.contains(weather3));
    }

    @Test
    public void testGetForecast() {
        // Create test weather data
        Weather weather1 = new Weather("London", 20);
        Weather weather2 = new Weather("Paris", 25);
        Weather weather3 = new Weather("New York", 15);
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather1);
        weatherList.add(weather2);
        weatherList.add(weather3);

        // Get the weather forecast for the next 3 days
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer();
        List<Weather> forecast = weatherAnalyzer.getForecast(weatherList, 3);

        // Verify the forecast size
        Assertions.assertEquals(3, forecast.size());
        // Additional assertions for the specific forecast details
        // Assertions.assertEquals(expectedWeather1, forecast.get(0));
        // Assertions.assertEquals(expectedWeather2, forecast.get(1));
        // Assertions.assertEquals(expectedWeather3, forecast.get(2));
    }
    
    // Add more test methods for other WeatherAnalyzer functionalities
}

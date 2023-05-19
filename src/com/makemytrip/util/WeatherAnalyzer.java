package com.myapp.util;

import com.myapp.model.Destination;
import com.myapp.model.Weather;
import java.util.ArrayList;
import java.util.List;

public class WeatherAnalyzer {
    public List<Destination> filterDestinationsByTemperatureAndRain(List<Destination> destinations, int minTemperature, int maxTemperature) {
        List<Destination> filteredDestinations = new ArrayList<>();

        for (Destination destination : destinations) {
            Weather weather = destination.getWeather();

            if (weather != null && isTemperatureInRange(weather, minTemperature, maxTemperature) && !hasHeavyRain(weather)) {
                filteredDestinations.add(destination);
            }
        }

        return filteredDestinations;
    }

    private boolean isTemperatureInRange(Weather weather, int minTemperature, int maxTemperature) {
        double temperature = weather.getTemperature();
        return temperature >= minTemperature && temperature <= maxTemperature;
    }

    private boolean hasHeavyRain(Weather weather) {
        double precipitation = weather.getPrecipitation();
    double rainfallIntensity = weather.getRainfallIntensity();

    // Check if precipitation or rainfall intensity exceeds a certain threshold
    // You can customize the threshold values based on your definition of heavy rain
    double precipitationThreshold = 10.0; // millimeters
    double rainfallIntensityThreshold = 5.0; // millimeters per hour

    return precipitation > precipitationThreshold || rainfallIntensity > rainfallIntensityThreshold;
    }
}

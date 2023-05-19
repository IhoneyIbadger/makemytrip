package com.myapp.util;

import com.myapp.model.Destination;
import com.myapp.model.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherAnalyzer {
    public List<Destination> filterDestinationsByTemperature(List<Destination> destinations, int minTemperature, int maxTemperature) {
        List<Destination> filteredDestinations = new ArrayList<>();
        
        for (Destination destination : destinations) {
            Weather weather = destination.getWeather();
            
            if (weather != null && weather.getTemperature() >= minTemperature && weather.getTemperature() <= maxTemperature) {
                filteredDestinations.add(destination);
            }
        }
        
        return filteredDestinations;
    }
}

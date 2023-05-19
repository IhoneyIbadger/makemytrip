package com.myapp.service;

import com.myapp.model.Destination;
import com.myapp.model.Weather;
import com.myapp.util.WeatherDataRetriever;

public class WeatherService {
    private WeatherDataRetriever weatherDataRetriever;

    public WeatherService() {
        this.weatherDataRetriever = new WeatherDataRetriever();
    }

    public Weather getWeatherForDestination(Destination destination) {
        return weatherDataRetriever.retrieveWeatherData(destination.getName());
    }
}

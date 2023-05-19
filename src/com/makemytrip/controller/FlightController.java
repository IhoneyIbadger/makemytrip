package com.myapp.controller;

import com.myapp.model.Destination;
import com.myapp.service.FlightDataService;
import java.util.List;

public class FlightController {
    private FlightDataService flightDataService;
    private RecommendationService recommendationService;

    public FlightController() {
        this.flightDataService = new FlightDataService();
        this.recommendationService = new RecommendationService();
    }

    public List<Flight> getRecommendedFlights(Destination destination) {
        return flightDataService.getRecommendedFlights(destination);
    }

}
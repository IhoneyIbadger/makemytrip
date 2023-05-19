package com.myapp.service;

import com.myapp.model.Destination;
import com.myapp.model.Flight;
import com.myapp.util.FlightDataAnalyzer;
import com.myapp.util.FlightDataRetriever;
import java.util.List;

public class FlightDataService {
    private FlightDataRetriever flightDataRetriever;
    private FlightDataAnalyzer flightDataAnalyzer;

    public FlightDataService() {
        this.flightDataRetriever = new FlightDataRetriever();
        this.flightDataAnalyzer = new FlightDataAnalyzer();
    }

    public List<Flight> getRecommendedFlights(Destination destination) {
        List<Flight> flights = flightDataRetriever.retrieveFlights(destination);
        List<Destination> destinations = getAllDestinations(); // Assuming you have a method to retrieve destinations
        List<Flight> analyzedFlights = flightDataAnalyzer.analyzeFlights(flights, destinations);
        return analyzedFlights;
    }
}

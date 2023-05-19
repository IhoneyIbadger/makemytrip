package com.myapp.util;

import com.myapp.model.Destination;
import com.myapp.model.Flight;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlightDataAnalyzer {
    public List<Flight> analyzeFlights(List<Flight> flights, List<Destination> destinations) {
        List<Flight> analyzedFlights = new ArrayList<>();

        // Sort flights by price (ascending order)
        flights.sort(Comparator.comparingDouble(Flight::getPrice));

        // Iterate through sorted flights and find corresponding destination by index
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            if (i < destinations.size()) {
                Destination destination = destinations.get(i);
                flight.setDestination(destination);
                analyzedFlights.add(flight);
            }
        }

        return analyzedFlights;
    }
}

package com.myapp.util;

import com.myapp.model.Flight;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FlightAnalyzer {
    public void sortFlightsByPrice(List<Flight> flights) {
        Collections.sort(flights, Comparator.comparingInt(Flight::getPrice));
    }

    public void filterFlightsByDuration(List<Flight> flights, int minDuration, int maxDuration) {
        flights.removeIf(flight -> flight.getDuration() < minDuration || flight.getDuration() > maxDuration);
    }
}

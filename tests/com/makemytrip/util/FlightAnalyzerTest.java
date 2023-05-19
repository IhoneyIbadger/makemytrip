package com.myapp.util;

import com.myapp.model.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FlightAnalyzerTest {
    @Test
    public void testSortFlightsByPrice() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("F001", "AA", 250));
        flights.add(new Flight("F002", "BB", 150));
        flights.add(new Flight("F003", "CC", 300));

        FlightAnalyzer analyzer = new FlightAnalyzer();
        analyzer.sortFlightsByPrice(flights);

        Assertions.assertEquals("F002", flights.get(0).getId());
        Assertions.assertEquals("F001", flights.get(1).getId());
        Assertions.assertEquals("F003", flights.get(2).getId());
    }

    @Test
    public void testFilterFlightsByDuration() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("F001", "AA", 200, 2));
        flights.add(new Flight("F002", "BB", 300, 3));
        flights.add(new Flight("F003", "CC", 400, 4));

        FlightAnalyzer analyzer = new FlightAnalyzer();
        analyzer.filterFlightsByDuration(flights, 2, 3);

        Assertions.assertEquals(2, flights.size());
        Assertions.assertEquals("F001", flights.get(0).getId());
        Assertions.assertEquals("F002", flights.get(1).getId());
    }

    // Other flight analysis test methods...
}

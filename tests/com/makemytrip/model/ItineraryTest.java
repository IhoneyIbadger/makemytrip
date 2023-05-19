package com.myapp.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ItineraryTest {
    @Test
    public void testItinerary() {
        Itinerary itinerary = new Itinerary();
        
        Destination destination = new Destination("Paris", "The City of Lights", "France", 5);
        Flight flight = new Flight("LHR", "CDG", "2023-06-01", 100);
        
        itinerary.addDestination(destination);
        itinerary.addFlight(flight);
        
        List<Destination> destinations = itinerary.getDestinations();
        Assertions.assertEquals(1, destinations.size());
        Assertions.assertTrue(destinations.contains(destination));
        
        List<Flight> flights = itinerary.getFlights();
        Assertions.assertEquals(1, flights.size());
        Assertions.assertTrue(flights.contains(flight));
        
        itinerary.setStartDate("2023-05-01");
        itinerary.setEndDate("2023-06-01");
        itinerary.setTotalCost(2000);
        
        Assertions.assertEquals("2023-05-01", itinerary.getStartDate());
        Assertions.assertEquals("2023-06-01", itinerary.getEndDate());
        Assertions.assertEquals(2000, itinerary.getTotalCost());
    }
}

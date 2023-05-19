package com.myapp.model;

import java.util.ArrayList;
import java.util.List;

public class Itinerary {
    private List<Destination> destinations;
    private List<Flight> flights;
    private String startDate;
    private String endDate;
    private int totalCost;

    public Itinerary() {
        this.destinations = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    // Add a destination to the itinerary
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    // Add a flight to the itinerary
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    // Getters and Setters

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}

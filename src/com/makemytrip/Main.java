package com.myapp;

public class Main {
    public static void main(String[] args) {
        // Your application logic goes here
        
        // Example code: Print a welcome message
        System.out.println("Welcome to My App!");
        
        // Create instances of other classes and use them as needed
        
        // Example code: Create a Destination object
        Destination destination = new Destination("Paris", "The City of Lights", "France", 5);
        
        // Example code: Print destination details
        System.out.println("Destination: " + destination.getName());
        System.out.println("Description: " + destination.getDescription());
        System.out.println("Country: " + destination.getCountry());
        System.out.println("Rating: " + destination.getRating());
        
        // Example code: Retrieve flights using FlightDataRetriever
        FlightDataRetriever flightDataRetriever = new FlightDataRetriever();
        List<Flight> flights = flightDataRetriever.retrieveFlights(destination);
        
        // Example code: Print flight details
        for (Flight flight : flights) {
            System.out.println("Flight from " + flight.getSource() + " to " + flight.getDestination());
            System.out.println("Departure date: " + flight.getDepartureDate());
            System.out.println("Price: " + flight.getPrice());
        }
        
        // Example code: Analyze flights using FlightAnalyzer
        FlightAnalyzer flightAnalyzer = new FlightAnalyzer();
        List<Flight> sortedFlights = flightAnalyzer.sortByPrice(flights);
        
        // Example code: Print sorted flight details
        System.out.println("Sorted flights by price:");
        for (Flight flight : sortedFlights) {
            System.out.println("Flight from " + flight.getSource() + " to " + flight.getDestination());
            System.out.println("Departure date: " + flight.getDepartureDate());
            System.out.println("Price: " + flight.getPrice());
        }
        
        // Continue with the rest of your application logic
    }
}

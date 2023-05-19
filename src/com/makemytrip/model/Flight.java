package com.tripplanner.model;

public class Flight {
    private String airline;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private String departureDate;
    private String arrivalDate;
    private String price;

    public Flight(String airline, String flightNumber, String departureAirport, String arrivalAirport, String departureTime, String arrivalTime, String departureDate, String arrivalDate, String price) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
    }

    // Getters

    public String getAirline() {
        return airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() { return departureAirport; }

    public String getArrivalAirport() { return arrivalAirport; }

    public String getDepartureTime() { return departureTime; }

    public String getArrivalTime() { return arrivalTime; }

    public String getDepartureDate() { return departureDate; }

    public String getArrivalDate() { return arrivalDate; }

    public String getPrice() { return price; }

    // Setters

    public void setAirline(String airline) { this.airline = airline; }

    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public void setDepartureAirport(String departureAirport) { this.departureAirport = departureAirport; }

    public void setArrivalAirport(String arrivalAirport) { this.arrivalAirport = arrivalAirport; }

    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }

    public void setArrivalDate(String arrivalDate) { this.arrivalDate = arrivalDate; }

    public void setPrice(String price) { this.price = price; }

    // toString

    @Override

    public String toString() {
        return "Flight{" +
                "airline='" + airline + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
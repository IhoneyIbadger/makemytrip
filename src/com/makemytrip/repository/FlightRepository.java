package com.myapp.repository;

import com.myapp.model.Flight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FlightRepository {
    private final String url;
    private final String username;
    private final String password;

    public FlightRepository(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void saveFlight(Flight flight) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO flights (flight_id, destination, price, date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, flight.getFlightId());
            statement.setString(2, flight.getDestination());
            statement.setDouble(3, flight.getPrice());
            statement.setDate(4, flight.getDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Flight> getFlightsByDestination(String destination) {
        List<Flight> flights = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM flights WHERE destination = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, destination);
            ResultSet resultSet = statement.executeQuery();
    
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getString("flight_id"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setPrice(resultSet.getDouble("price"));
                flight.setDate(resultSet.getDate("date"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
    
    public List<Flight> getFlightsByPriceRange(double minPrice, double maxPrice) {
        List<Flight> flights = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM flights WHERE price BETWEEN ? AND ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);
            ResultSet resultSet = statement.executeQuery();
    
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getString("flight_id"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setPrice(resultSet.getDouble("price"));
                flight.setDate(resultSet.getDate("date"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
    
    public void deleteFlightById(String flightId) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "DELETE FROM flights WHERE flight_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, flightId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateFlight(Flight flight) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE flights SET destination = ?, price = ?, date = ? WHERE flight_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, flight.getDestination());
            statement.setDouble(2, flight.getPrice());
            statement.setDate(3, flight.getDate());
            statement.setString(4, flight.getFlightId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}

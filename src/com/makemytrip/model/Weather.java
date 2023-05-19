package com.tripplanner.model;

public class Weather{
    private String date;
    private String temperature;
    private String description;
    private String icon;

    public Weather(String date, String temperature, String description, String icon) {
        this.date = date;
        this.temperature = temperature;
        this.description = description;
        this.icon = icon;
    }

    // Getters

    public String getDate() {
        return date;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getDescription() { return description; }

    public String getIcon() { return icon; }

    // Setters

    public void setDate(String date) { this.date = date; }

    public void setTemperature(String temperature) { this.temperature = temperature; }

    public void setDescription(String description) { this.description = description; }

    public void setIcon(String icon) { this.icon = icon; }

    // toString

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", temperature='" + temperature + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
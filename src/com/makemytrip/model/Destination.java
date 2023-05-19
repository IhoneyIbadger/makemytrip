package com.tripplanner.model;

public class Destination {
    private String name;
    private String description;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Destination(String name, String description, String address, String city, String state, String zip, String country) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() { return address; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public String getZip() { return zip; }

    public String getCountry() { return country; }

    // Setters

    public void setName(String name) { this.name = name; }

    public void setDescription(String description) { this.description = description; }

    public void setAddress(String address) { this.address = address; }

    public void setCity(String city) { this.city = city; }

    public void setState(String state) { this.state = state; }

    public void setZip(String zip) { this.zip = zip; }

    public void setCountry(String country) { this.country = country; }

    // toString

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    // equals

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;

        Destination that = (Destination) o;

        if (!name.equals(that.name)) return false;
        if (!description.equals(that.description)) return false;
        if (!address.equals(that.address)) return false;
        if (!city.equals(that.city)) return false;
        if (!state.equals(that.state)) return false;
        if (!zip.equals(that.zip)) return false;
        return country.equals(that.country);
    }
    
}
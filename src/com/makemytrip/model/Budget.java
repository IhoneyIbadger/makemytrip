package com.myapp.model;

public class Budget {
    private int maxFlightCost;
    private int maxAccommodationCost;
    private int maxExpense;

    public Budget(int maxFlightCost, int maxAccommodationCost, int maxExpense) {
        this.maxFlightCost = maxFlightCost;
        this.maxAccommodationCost = maxAccommodationCost;
        this.maxExpense = maxExpense;
    }

    // Getters and Setters

    public int getMaxFlightCost() {
        return maxFlightCost;
    }

    public void setMaxFlightCost(int maxFlightCost) {
        this.maxFlightCost = maxFlightCost;
    }

    public int getMaxAccommodationCost() {
        return maxAccommodationCost;
    }

    public void setMaxAccommodationCost(int maxAccommodationCost) {
        this.maxAccommodationCost = maxAccommodationCost;
    }

    public int getMaxExpense() {
        return maxExpense;
    }

    public void setMaxExpense(int maxExpense) {
        this.maxExpense = maxExpense;
    }
}

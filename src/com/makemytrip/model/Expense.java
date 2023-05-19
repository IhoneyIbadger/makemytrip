package com.myapp.model;

public class Expense {
    private String name;
    private double cost;

    public Expense() {
    }

    public Expense(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

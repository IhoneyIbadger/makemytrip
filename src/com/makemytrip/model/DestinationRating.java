package com.myapp.model;

public class DestinationRating {
    private String destinationName;
    private int rating;
    private String comment;

    public DestinationRating(String destinationName, int rating, String comment) {
        this.destinationName = destinationName;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and Setters

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

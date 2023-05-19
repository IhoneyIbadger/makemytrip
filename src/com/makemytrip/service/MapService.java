package com.myapp.service;

import com.myapp.util.MapProvider;

public class MapService {
    private MapProvider mapProvider;

    public MapService() {
        this.mapProvider = new MapProvider();
    }

    public void displayMap(String location) {
        mapProvider.displayMap(location);
    }

    public double calculateDistance(String source, String destination) {
        return mapProvider.calculateDistance(source, destination);
    }

    // Other map-related methods...
}

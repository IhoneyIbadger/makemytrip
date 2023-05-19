package com.myapp.controller;

import com.myapp.model.Destination;
import com.myapp.service.RecommendationService;
import java.util.List;

public class RecommendationController {
    private RecommendationService recommendationService;

    public RecommendationController() {
        this.recommendationService = new RecommendationService();
    }

    public List<Destination> getRecommendedDestinations(String userId) {
        return recommendationService.getRecommendedDestinations(userId);
    }
}
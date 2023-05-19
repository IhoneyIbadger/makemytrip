package com.myapp.controller;

import com.myapp.model.Destination;
import com.myapp.service.RecommendationService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommendations")
    public ResponseEntity<RecommendationResponse> getRecommendations(
            @RequestParam String currentLocation,
            @RequestParam String userId
    ) {
        // Call the recommendation service to generate recommendations
        Recommendation recommendation = recommendationService.generateRecommendation(currentLocation, userId);

        if (recommendation != null) {
            RecommendationResponse response = new RecommendationResponse(recommendation.getDepartureTime());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

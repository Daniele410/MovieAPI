package com.daniele.movies.controller;

import com.daniele.movies.model.Review;
import com.daniele.movies.service.IReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final IReviewService reviewService;

    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReview (@RequestBody String id){
        return new ResponseEntity<>(reviewService.deleteReview(id),HttpStatus.ACCEPTED);
    }

}

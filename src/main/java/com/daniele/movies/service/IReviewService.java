package com.daniele.movies.service;

import com.daniele.movies.model.Review;

public interface IReviewService {
    Review createReview(String reviewBody, String imdbId);
}

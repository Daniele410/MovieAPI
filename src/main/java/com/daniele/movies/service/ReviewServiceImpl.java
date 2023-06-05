package com.daniele.movies.service;

import com.daniele.movies.model.Movie;
import com.daniele.movies.model.Review;
import com.daniele.movies.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements IReviewService {

    private final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);
    private final ReviewRepository reviewRepository;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, MongoTemplate mongoTemplate) {
        this.reviewRepository = reviewRepository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        log.info("create review:" + reviewBody + "for id: " + imdbId);

        return review;

    }

    @Override
    public String deleteReview(String id){
        Optional<Review> review = reviewRepository.findReviewById(id);
        review.ifPresent(reviewRepository::delete);
        return "review id: " + id + " deleted!";

    }

}

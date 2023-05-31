package com.daniele.movies.service;

import com.daniele.movies.model.Movie;
import com.daniele.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements IMovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);


    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        log.info("get All Movies");
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> singleMovieById(ObjectId id) {
        log.info("Get single movie by id: " + id);
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> singleMovieByImdbId(String imdbId) {
        log.info("Get single movie by imdbId: " + imdbId);
        return movieRepository.findMovieByImdbId(imdbId);
    }

    @Override
    public Optional<List<Movie>> movieByGenres(String genres) {
        log.info("Get movie by genres: " + genres);
        return movieRepository.findMovieByGenres(genres);
    }

}

package com.daniele.movies.service;

import com.daniele.movies.model.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<Movie> getAllMovies();

    Optional<Movie> singleMovieById(ObjectId id);

    Optional<Movie> singleMovieByImdbId(String id);

    Optional<List<Movie>> movieByGenres(String genres);
}

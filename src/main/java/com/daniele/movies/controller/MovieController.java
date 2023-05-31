package com.daniele.movies.controller;

import com.daniele.movies.model.Movie;
import com.daniele.movies.service.IMovieService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovieById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieById(id),HttpStatus.OK);
    }

    @GetMapping("/imdbId/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(imdbId),HttpStatus.OK);
    }

    @GetMapping("/genres/{genres}")
    public ResponseEntity<Optional<List<Movie>>> getMovieByGenres(@PathVariable String genres){
        return new ResponseEntity<>(movieService.movieByGenres(genres), HttpStatus.OK);
    }

}

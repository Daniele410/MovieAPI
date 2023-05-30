package com.daniele.movies.controller;

import com.daniele.movies.model.Movie;
import com.daniele.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final IMovieService iMovieService;

    @Autowired
    public MovieController(IMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(iMovieService.getAllMovies(), HttpStatus.OK);
    }
}

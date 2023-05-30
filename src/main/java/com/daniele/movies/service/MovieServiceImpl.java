package com.daniele.movies.service;

import com.daniele.movies.model.Movie;
import com.daniele.movies.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements IMovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);



    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies(){
        log.info("get All Movies");
       return movieRepository.findAll();
    }
}

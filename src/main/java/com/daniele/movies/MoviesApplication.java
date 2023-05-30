package com.daniele.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
public class MoviesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

//	@GetMapping("/root")
//	public String apiRoot(){
//		return "Hello, World!";
//	}

}

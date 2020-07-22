package com.sageNepal.MovieFinder.controller;

import com.sageNepal.MovieFinder.dto.MovieDto;
import com.sageNepal.MovieFinder.service.MovieService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @SneakyThrows
    @GetMapping
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<List<MovieDto>>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/unique-movies")
    public ResponseEntity<List<MovieDto>> getUniqueMoviesList() {
        return new ResponseEntity<List<MovieDto>>(movieService.getUniqueMoviesList(), HttpStatus.OK);
    }

    @GetMapping("/get-promo-Movies")
    public ResponseEntity<List<MovieDto>> getLimitedMovies() {
        return new ResponseEntity<List<MovieDto>>(movieService.getLimitedMovies(), HttpStatus.OK);
    }

    @GetMapping("/movie/{movieName}")
    public ResponseEntity<List<MovieDto>> getMoviesByName(@PathVariable String movieName) {
        return new ResponseEntity<>(movieService.getMoviesByTitle(movieName), HttpStatus.OK);
    }

    @GetMapping("/getAllMoviesWithLocation")
    public ResponseEntity<List<MovieDto>> getAllMoviesWithLocation() {
        return new ResponseEntity<>(movieService.getAllMoviesWithLocation(), HttpStatus.OK);
    }

    @GetMapping("/find-by-location/{location}")
    public ResponseEntity<List<MovieDto>> getMoviesByLocation(@PathVariable String location) {
        return new ResponseEntity<List<MovieDto>>(movieService.getMoviesByLocation(location), HttpStatus.OK);
    }

    @GetMapping("/locations-list")
    public ResponseEntity<List<MovieDto>> getLocations() {
        return new ResponseEntity<List<MovieDto>>(movieService.getLocations(), HttpStatus.OK);
    }

    @GetMapping("/get-movies-details")
    public ResponseEntity<MovieDto> getMoviesByDetails(@RequestParam String title, @RequestParam String location) {
        return new ResponseEntity<MovieDto>(movieService.getMoviesByDetails(title,location), HttpStatus.OK);
    }
}

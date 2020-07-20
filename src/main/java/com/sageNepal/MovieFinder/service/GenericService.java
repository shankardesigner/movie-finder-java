package com.sageNepal.MovieFinder.service;

import com.sageNepal.MovieFinder.dto.MovieDto;

import java.util.List;

public interface GenericService<T> {
    List<T> getAll();
    List<T> getUniqueMoviesList();
    List<T> getLimitedMovies();
    List<T> getMoviesByTitle(String title);
    List<T> getAllMoviesWithLocation();
    List<T> getMoviesByLocation(String location);
    List<MovieDto> getLocations();
}

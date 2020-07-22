package com.sageNepal.MovieFinder.service;

import com.sageNepal.MovieFinder.dto.MovieDto;
import com.sageNepal.MovieFinder.utils.GoogleSearchUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieService implements GenericService<MovieDto> {
    private List<MovieDto> moviesList = new ArrayList<MovieDto>();
    private List<MovieDto> uniqueMoviesList = new ArrayList<MovieDto>();

    @Autowired
    private ResourceService resourceService;

    @Override
    public List<MovieDto> getAll() {
        moviesList = resourceService.getMoviesList();
        return moviesList;
    }

    @Override
    public List<MovieDto> getUniqueMoviesList() {
        if(!(moviesList.size() > 0)) getAll();
        List<MovieDto> originaList = new ArrayList<>(moviesList);
        uniqueMoviesList = new ArrayList(originaList.stream().collect(Collectors.toMap(MovieDto::getTitle, p -> p, (p, q) -> p)).values());
        return uniqueMoviesList;
    }

    @Override
    public List<MovieDto> getLimitedMovies() {
        if(!(uniqueMoviesList.size() > 0)) getUniqueMoviesList();
        List<MovieDto> originalList = new ArrayList<>(uniqueMoviesList);
        List<MovieDto> limitedMoviesList = originalList.stream().filter(mv -> mv.getRelease_year() >= 2017).limit(4).collect(Collectors.toList());
//        originalList.stream().forEach(mv -> mv.setPosterUri(GoogleSearchUtils.getUri(mv.getTitle() + " Directed by " + mv.getDirector())));
        return limitedMoviesList;
    }

    @Override
    public List<MovieDto> getMoviesByTitle(String title) {
        if(!(moviesList.size() > 0)) getAll();
        List<MovieDto> originaList = new ArrayList<>(moviesList);
        List<MovieDto> filteredList = originaList.stream().filter(m -> m.getTitle().contains(title)).collect(Collectors.toList());
        return filteredList;
    }

    @Override
    public List<MovieDto> getAllMoviesWithLocation() {
        if(!(moviesList.size() > 0)) getAll();
        moviesList.stream().forEach(mv -> mv.setAddressInfo(resourceService.getLatLong(mv.getLocations())));
        return moviesList;
    }

    @Override
    public List<MovieDto> getMoviesByLocation(String location) {
        if(!(moviesList.size() > 0)) getAll();
        List<MovieDto> originalList = new ArrayList<>(moviesList);
        List<MovieDto> filteredList = originalList.stream().filter(m -> m.getLocations() != null && m.getLocations().contains(location)).collect(Collectors.toList());
        return filteredList;
    }

    @Override
    public List<MovieDto> getLocations() {
        if(!(moviesList.size() > 0)) getAll();
        List<MovieDto> originalList = new ArrayList<>(moviesList);
        List<MovieDto> locationList = new ArrayList(originalList.stream().collect(Collectors.toMap(MovieDto::getLocations, p -> p, (p, q) -> p)).values());
        return locationList;
    }

    @Override
    public MovieDto getMoviesByDetails(String title, String location) {
        List<MovieDto> originalList = new ArrayList<>(moviesList);
        MovieDto filteredMovie = originalList.stream().filter(mv -> mv.getTitle().contains(title) && mv.getLocations().contains(location)).collect(Collectors.toList()).get(0);
        filteredMovie.setPosterUri(GoogleSearchUtils.getUri(title + " " + location));

        return filteredMovie;
    }
}

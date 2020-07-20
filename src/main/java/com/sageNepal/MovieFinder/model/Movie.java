package com.sageNepal.MovieFinder.model;

import lombok.Data;

@Data
public class Movie {
    private String title;
    private int release_year;
    private String locations;
    private String production_company;
    private String director;
    private String writer;
    private String actor_1;
    private String actor_2;
    private String actor_3;
}

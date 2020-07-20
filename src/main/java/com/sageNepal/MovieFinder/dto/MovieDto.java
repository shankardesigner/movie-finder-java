package com.sageNepal.MovieFinder.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private String title;
    private int release_year;
    private String posterUri;
    private String locations;
    private String production_company;
    private String director;
    private String writer;
    private String actor_1;
    private String actor_2;
    private String actor_3;
    private Object addressInfo;
}

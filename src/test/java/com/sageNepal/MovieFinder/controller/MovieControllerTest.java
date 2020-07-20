package com.sageNepal.MovieFinder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sageNepal.MovieFinder.dto.MovieDto;
import com.sageNepal.MovieFinder.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class MovieControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @MockBean
    MovieService movieService;

    ObjectMapper objectMapper =  new ObjectMapper();

    @BeforeEach
    void setUp() {
        DefaultMockMvcBuilder defaultMockMvcBuilder = MockMvcBuilders.webAppContextSetup(context);
        mockMvc= defaultMockMvcBuilder.build();
    }

    @Test
    void getAllMoviesTest() throws Exception{
        MovieDto movieDto = new MovieDto();
        List<MovieDto> List = Arrays.asList(new MovieDto("Ramhari",150,"220","220","220","220","220","220","220","220","kathmandu"));

        /*when(movieService.getAll()).thenReturn();
        mockMvc.perform(MockMvcRequestBuilders.get("/unique-movies").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(movieDto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].movieName", is("ramhari")));*/
    }

    @Test
    void getUniqueMoviesListTest() {
    }

    @Test
    void getLimitedMoviesTest() {
    }

    @Test
    void getMoviesByNameTest() {
    }

    @Test
    void getMoviesByLocationTest() {
    }

    @Test
    void getLocationsTest() {
    }
}
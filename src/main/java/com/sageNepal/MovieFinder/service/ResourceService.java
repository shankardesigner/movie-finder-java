package com.sageNepal.MovieFinder.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.sageNepal.MovieFinder.dto.MovieDto;
import com.sageNepal.MovieFinder.utils.Constants;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceService {
    @Autowired
    private RestTemplate restTemplate;

    private List<MovieDto> moviesList = new ArrayList<MovieDto>();

    public List<MovieDto> getMoviesList() {
//        moviesList = Arrays.stream(restTemplate.getForObject("https://data.sfgov.org/resource/yitu-d5am.json", MovieDto[].class)).collect(Collectors.toList());
        /*moviesList.forEach(movie -> {
            movie.setPosterUri(GoogleSearchUtils.getUri(movie.getTitle()));
        });*/
        Gson gson = new Gson();
        JSONParser jsonParser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = classLoader.getResourceAsStream("Movies.json");
        JsonReader jsonReader = new JsonReader(new InputStreamReader(in));
        moviesList = Arrays.asList(gson.fromJson(jsonReader, MovieDto[].class));
        System.out.println(moviesList);
        return moviesList;
    }

    public Object getLatLong(String address) {
        String requestObject =  restTemplate
                .getForObject(Constants.MAP_API_URI + "address?key=" + Constants.MAP_API_KEY + "&location=" + address, String.class);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode node = objectMapper.readValue(requestObject, JsonNode.class);
            JsonNode results = node.get("results");
            return results.get(0).get("locations").get(0).get("displayLatLng");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}

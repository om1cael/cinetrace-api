package com.cinetrace.api.services;

import com.cinetrace.api.dto.MovieDTO;
import com.cinetrace.api.dto.TMDBPopularDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${API_KEY}")
    private String apiKey;
    final String popularMoviesApiUrl = "https://api.themoviedb.org/3/movie/popular?language=en-US&page=1?api_key=";

    List<MovieDTO> getPopularMovies() {
       final String apiUrl = popularMoviesApiUrl + apiKey;

       TMDBPopularDTO response = restTemplate.getForObject(apiUrl, TMDBPopularDTO.class);
       return response != null ? response.movies() : Collections.emptyList();
    }
}

package com.cinetrace.api.services;

import com.cinetrace.api.clients.TMDBClient;
import com.cinetrace.api.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private TMDBClient tmdbClient;

    @Value("${API_KEY}")
    private String apiKey;

    public List<MovieDTO> getPopularMovies() {
        return tmdbClient.getPopularMovies("Bearer " + apiKey).results();
    }
}

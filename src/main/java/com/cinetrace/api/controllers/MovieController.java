package com.cinetrace.api.controllers;

import com.cinetrace.api.dto.MovieDTO;
import com.cinetrace.api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/popular")
    private List<MovieDTO> getPopularMovies() {
        return movieService.getPopularMovies();
    }
}

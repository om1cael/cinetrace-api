package com.cinetrace.api.clients;

import com.cinetrace.api.dto.TMDBPopularDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "tmdbClient", url = "https://api.themoviedb.org/3")
public interface TMDBClient {
    @GetMapping("/movie/popular")
    TMDBPopularDTO getPopularMovies(@RequestHeader("Authorization") String authorization);
}

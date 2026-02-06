package com.cinetrace.api.clients;

import com.cinetrace.api.dto.MovieDTO;
import com.cinetrace.api.dto.TMDBMovieList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "tmdbClient", url = "https://api.themoviedb.org/3")
public interface TMDBClient {
    @GetMapping("/movie/popular")
    TMDBMovieList getPopularMovies(@RequestHeader("Authorization") String authorization);

    @GetMapping("/movie/{id}")
    MovieDTO getMovieById(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id);
}

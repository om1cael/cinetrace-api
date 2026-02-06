package com.cinetrace.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TMDBMovieListDTO(List<MovieDTO> results) {
}

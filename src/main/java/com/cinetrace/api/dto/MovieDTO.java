package com.cinetrace.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieDTO(
        Long id,
        String title,
        String overview,
        @JsonProperty("release_date") LocalDate releaseDate,
        boolean adult
) {
}

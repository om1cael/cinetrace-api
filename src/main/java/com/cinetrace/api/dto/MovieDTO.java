package com.cinetrace.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record MovieDTO(
        Long id,
        String title,
        String overview,
        @JsonProperty("release_date") Date releaseDate,
        boolean adult
) {
}

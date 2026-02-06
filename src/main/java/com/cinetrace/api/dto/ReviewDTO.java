package com.cinetrace.api.dto;

public record ReviewDTO(
        Long movieId,
        String author,
        String content,
        int stars
) {
}

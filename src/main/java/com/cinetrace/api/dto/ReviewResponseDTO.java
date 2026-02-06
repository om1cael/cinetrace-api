package com.cinetrace.api.dto;

public record ReviewResponseDTO(
        Long id,
        Long movieId,
        String author,
        String content,
        int stars
) {
}

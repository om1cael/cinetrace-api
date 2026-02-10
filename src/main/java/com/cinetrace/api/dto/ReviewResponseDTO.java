package com.cinetrace.api.dto;

import java.time.OffsetDateTime;

public record ReviewResponseDTO(
        Long id,
        Long movieId,
        String author,
        String content,
        int stars,
        OffsetDateTime createdAt
) {
}

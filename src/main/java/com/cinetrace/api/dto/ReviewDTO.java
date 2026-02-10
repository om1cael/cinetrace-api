package com.cinetrace.api.dto;

public record ReviewDTO(
        String author,
        String content,
        int stars
) {
}

package com.cinetrace.api.controllers;

import com.cinetrace.api.dto.ReviewDTO;
import com.cinetrace.api.dto.ReviewResponseDTO;
import com.cinetrace.api.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/{movieId}")
    ResponseEntity<ReviewResponseDTO> createReview(@PathVariable("movieId") Long movieId, @RequestBody @Valid ReviewDTO reviewDTO) {
        ReviewResponseDTO response = reviewService.createReview(movieId, reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{movieId}")
    List<ReviewResponseDTO> getAllReviews(@PathVariable("movieId") Long movieId) {
        return reviewService.getAllReviews(movieId);
    }
}

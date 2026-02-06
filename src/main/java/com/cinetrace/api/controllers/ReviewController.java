package com.cinetrace.api.controllers;

import com.cinetrace.api.dto.ReviewDTO;
import com.cinetrace.api.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping()
    void createReview(@RequestBody @Valid ReviewDTO reviewDTO) {
        reviewService.createReview(reviewDTO);
    }

    @GetMapping("/{movieId}")
    List<ReviewDTO> getAllReviews(@PathVariable("movieId") Long movieId) {
        return reviewService.getAllReviews(movieId);
    }
}

package com.cinetrace.api.controllers;

import com.cinetrace.api.dto.ReviewDTO;
import com.cinetrace.api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{movieId}/all")
    List<ReviewDTO> getAllReviews(@PathVariable("movieId") Long movieId) {
        return reviewService.getAllReviews(movieId);
    }
}

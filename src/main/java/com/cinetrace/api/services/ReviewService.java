package com.cinetrace.api.services;

import com.cinetrace.api.dto.ReviewDTO;
import com.cinetrace.api.models.ReviewModel;
import com.cinetrace.api.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    public List<ReviewDTO> getAllReviews(Long movieId) {
        List<ReviewModel> repositoryReviews = repository.findByMovieId(movieId)
                .orElseThrow(EntityNotFoundException::new);

        ArrayList<ReviewDTO> reviews = new ArrayList<>();
        for(ReviewModel reviewModel : repositoryReviews) {
            ReviewDTO review = new ReviewDTO(
                reviewModel.getMovieId(),
                reviewModel.getAuthor(),
                reviewModel.getContent(),
                reviewModel.getStars()
            );

            reviews.add(review);
        }

        return reviews;
    }
}

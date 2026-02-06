package com.cinetrace.api.services;

import com.cinetrace.api.clients.TMDBClient;
import com.cinetrace.api.dto.ReviewDTO;
import com.cinetrace.api.dto.ReviewResponseDTO;
import com.cinetrace.api.models.ReviewModel;
import com.cinetrace.api.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private TMDBClient tmdbClient;

    @Value("${API_KEY}")
    private String apiKey;

    public ReviewResponseDTO createReview(ReviewDTO reviewDTO) {
        if(tmdbClient.getMovieById("Bearer " + apiKey, reviewDTO.movieId()) == null) {
            throw new EntityNotFoundException();
        }

        ReviewModel reviewModel = new ReviewModel(reviewDTO);
        ReviewModel created = repository.save(reviewModel);

        return new ReviewResponseDTO(
                created.getId(),
                created.getMovieId(),
                created.getAuthor(),
                created.getContent(),
                created.getStars()
        );
    }

    public List<ReviewResponseDTO> getAllReviews(Long movieId) {
        List<ReviewModel> repositoryReviews = repository.findByMovieId(movieId)
                .orElseThrow(EntityNotFoundException::new);

        ArrayList<ReviewResponseDTO> reviews = new ArrayList<>();
        for(ReviewModel reviewModel : repositoryReviews) {
            ReviewResponseDTO review = new ReviewResponseDTO(
                reviewModel.getId(),
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

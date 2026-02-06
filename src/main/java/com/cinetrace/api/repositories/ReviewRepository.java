package com.cinetrace.api.repositories;

import com.cinetrace.api.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {
    Optional<List<ReviewModel>> findByMovieId(Long movieId);
}

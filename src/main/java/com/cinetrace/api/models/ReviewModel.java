package com.cinetrace.api.models;

import com.cinetrace.api.dto.ReviewDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
public class ReviewModel {
    public ReviewModel(Long movieId, ReviewDTO reviewDTO) {
        this.movieId = movieId;
        this.author = reviewDTO.author();
        this.content = reviewDTO.content();
        this.stars = reviewDTO.stars();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String author;

    @NotNull
    private Long movieId;

    @Size(min = 10, max = 500)
    @NotNull
    private String content;

    @Min(1)
    @Max(5)
    @NotNull
    private int stars;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;
}

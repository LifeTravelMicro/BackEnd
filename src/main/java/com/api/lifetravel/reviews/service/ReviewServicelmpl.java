package com.api.lifetravel.reviews.service;

import com.api.lifetravel.reviews.domain.model.entity.Review;
import com.api.lifetravel.reviews.domain.persistence.ReviewRepository;
import com.api.lifetravel.reviews.domain.service.ReviewService;
import com.api.lifetravel.shared.exception.ResourceValidationException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReviewServicelmpl implements ReviewService {

    private static final String ENTITY = "Review";
    private final ReviewRepository reviewRepository;
    private final Validator validator;

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Transactional
    @Override
    public Review create(Review review) {
        Set<ConstraintViolation<Review>> violations = validator.validate(review);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return reviewRepository.save(review);
    }

    @Override
    public Review delete(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        reviewRepository.delete(review);
        return review;
    }

}

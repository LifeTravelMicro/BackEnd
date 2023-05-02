package com.api.lifetravel.reviews.domain.service;

import com.api.lifetravel.reviews.domain.model.entity.Review;


import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    Review create(Review review);

    Review delete(Long id);

}

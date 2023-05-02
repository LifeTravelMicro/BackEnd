package com.api.lifetravel.reviews.domain.persistence;

import com.api.lifetravel.reviews.domain.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
}

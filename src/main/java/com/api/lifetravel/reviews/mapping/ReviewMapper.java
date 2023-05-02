package com.api.lifetravel.reviews.mapping;

import com.api.lifetravel.reviews.domain.model.entity.Review;
import com.api.lifetravel.reviews.resource.CreateReviewResource;
import com.api.lifetravel.reviews.resource.ReviewResource;
import com.api.lifetravel.reviews.resource.ReviewResourceId;
import com.api.lifetravel.shared.mapping.EnhancedModelMapper;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class ReviewMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;
    public ReviewMapper reviewMapper() {
        return new ReviewMapper(modelMapper);
    }

    public Page<ReviewResource> modelListPage(List<Review> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, ReviewResource.class), pageable, modelList.size());
    }

    public Review toModel(CreateReviewResource resource) {
        return modelMapper.map(resource, Review.class);
    }

    public ReviewResource toResource(Review review) {
        return modelMapper.map(review, ReviewResource.class);
    }
}

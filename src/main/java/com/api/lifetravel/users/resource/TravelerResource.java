package com.api.lifetravel.users.resource;

import com.api.lifetravel.reviews.domain.model.entity.Review;
import com.api.lifetravel.reviews.resource.ReviewResource;
import com.api.lifetravel.transports.resource.TransportResource;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TravelerResource {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<ReviewResource> reviews;
}
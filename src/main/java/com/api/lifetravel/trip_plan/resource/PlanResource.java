package com.api.lifetravel.trip_plan.resource;

import com.api.lifetravel.accommodations.resource.AccommodationResource;
import com.api.lifetravel.reviews.domain.model.entity.Review;
import com.api.lifetravel.reviews.resource.ReviewResource;
import com.api.lifetravel.transports.resource.TransportResource;
import com.api.lifetravel.transports.resource.TransportResourceId;
import com.api.lifetravel.users.domain.model.entity.Agency;
import com.api.lifetravel.users.resource.AgencyResource;
import com.api.lifetravel.users.resource.AgencyResourceId;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PlanResource {
    private Long id;
    private Long agencyId;
    private Long transportId;
    private Long accommodationId;
    private Long tourId;
    private String name;
    private String description;
    private String duration;
    private String capacity;
    private String thumbnail;
    private List<ReviewResource> reviews;
}

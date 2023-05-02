package com.api.lifetravel.accommodations.resource;

import com.api.lifetravel.accommodations.domain.model.entity.AccommodationImage;
import com.api.lifetravel.accommodations.domain.service.AccommodationImageService;
import com.api.lifetravel.users.resource.AgencyResourceId;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationResource {
    private Long id;
    private String details;
    private String location;
    private String price;
    private String available;
    private Long agencyId;
    private List<AccommodationImageResource> accommodationImages;
//    private List<AccommodationServiceEntity> services;
//    private List<AccommodationCondition> conditions;

}

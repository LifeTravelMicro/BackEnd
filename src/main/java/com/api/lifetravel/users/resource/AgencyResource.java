package com.api.lifetravel.users.resource;

import com.api.lifetravel.accommodations.resource.AccommodationResource;
import com.api.lifetravel.tours.resource.TourResource;
import com.api.lifetravel.transports.resource.TransportResource;
import com.api.lifetravel.trip_plan.resource.PlanResource;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AgencyResource {
    private Long id;
    private String name;
    private String email;
    private String ruc;
    private List<TransportResource> transports;
    private List<AccommodationResource> accommodations;
    private List<TourResource> tours;
    private List<PlanResource> plans;
}
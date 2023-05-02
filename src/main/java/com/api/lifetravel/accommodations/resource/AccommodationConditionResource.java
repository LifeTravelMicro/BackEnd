package com.api.lifetravel.accommodations.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationConditionResource {
    private Long id;
    private String checkIn;
    private String checkOut;
//    private List<Services> services;
//    private List<Conditions> conditions;
//    private List<AccommodationImages> accommodationImages;
}

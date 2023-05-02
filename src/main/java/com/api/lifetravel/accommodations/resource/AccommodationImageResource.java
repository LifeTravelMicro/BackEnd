package com.api.lifetravel.accommodations.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationImageResource {
    private Long id;
    private String path;
    private String accommodationId;
}

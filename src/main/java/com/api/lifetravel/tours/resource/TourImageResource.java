package com.api.lifetravel.tours.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TourImageResource {
    private Long id;
    private String path;
    private String tourId;
}

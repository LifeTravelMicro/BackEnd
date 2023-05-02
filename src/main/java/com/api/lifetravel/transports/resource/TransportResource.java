package com.api.lifetravel.transports.resource;


import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TransportResource {
    private Long id;
    private String type;
    private String seats;
    private String departureDate;
    private String returnDate;
    private String price;
    private String available;
    private Long agencyId;
    private List<TransportImageResource> transportImages;
}

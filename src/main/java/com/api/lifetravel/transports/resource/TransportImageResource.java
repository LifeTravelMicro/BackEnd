package com.api.lifetravel.transports.resource;

import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TransportImageResource {

    private Long id;
    private Long transportId;
    private String path;
}

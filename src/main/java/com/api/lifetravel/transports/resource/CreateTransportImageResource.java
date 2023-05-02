package com.api.lifetravel.transports.resource;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransportImageResource {

    @NotNull
    @NotBlank
    private String path;

    @NotNull
    @NotBlank
    @OneToOne
    @JoinColumn(name = "transport_id")
    private TransportResourceId transport;
}

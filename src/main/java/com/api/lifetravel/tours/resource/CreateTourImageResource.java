package com.api.lifetravel.tours.resource;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTourImageResource {

    @NotNull
    @NotBlank
    private String path;

    @NotNull
    @NotBlank
    @OneToOne
    @JoinColumn(name = "tour_id")
    private TourResourceId tour;

}

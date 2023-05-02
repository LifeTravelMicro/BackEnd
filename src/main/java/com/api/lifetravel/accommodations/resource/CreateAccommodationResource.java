package com.api.lifetravel.accommodations.resource;

import com.api.lifetravel.trip_plan.domain.model.entity.Plan;
import com.api.lifetravel.users.domain.model.entity.Agency;
import com.api.lifetravel.users.resource.AgencyResourceId;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccommodationResource {

    @NotNull
    @NotBlank
    private AgencyResourceId agency;

    @NotNull
    @NotBlank
    private String details;

    @NotNull
    @NotBlank
    private String location;

    @NotNull
    @NotBlank
    private String price;

    private String available;

}

package com.api.lifetravel.tours.resource;

import com.api.lifetravel.users.resource.AgencyResourceId;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTourResource {
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
    private String meetingPoint;

    @NotNull
    @NotBlank
    private String  price;

    private String available;

}

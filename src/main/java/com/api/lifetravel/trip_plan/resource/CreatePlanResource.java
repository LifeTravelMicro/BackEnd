package com.api.lifetravel.trip_plan.resource;

import com.api.lifetravel.accommodations.domain.model.entity.Accommodation;
import com.api.lifetravel.accommodations.resource.AccommodationResourceId;
import com.api.lifetravel.tours.resource.TourResourceId;
import com.api.lifetravel.transports.domain.model.entity.Transport;
import com.api.lifetravel.transports.resource.TransportResourceId;
import com.api.lifetravel.users.domain.model.entity.Agency;
import com.api.lifetravel.users.resource.AgencyResourceId;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlanResource {

    @NotNull
    @NotBlank
    private AgencyResourceId agency;

    @NotNull
    @NotBlank
    private TransportResourceId transport;

    @NotNull
    @NotBlank
    private AccommodationResourceId accommodation;

    @NotNull
    @NotBlank
    private TourResourceId tour;

    @NotNull
    @NotBlank
    @Size(max= 60)
    @Column(unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Size(max= 255)
    private String description;

    @NotNull
    @NotBlank
    @Size(max= 31, min=1)
    private String duration;

    @NotNull
    @NotBlank
    @Size(max=15)
    private String capacity ;

    @NotNull
    @NotBlank
    private String disponibility;

    @NotNull
    @NotBlank
    private String thumbnail;

    //    @NotNull
//    @NotBlank
//    @Size(max=255)
//    private String typeOfPackage ;
//
//    @NotNull
//    @NotBlank
//    @Size(max=255)
//    private String typeOfTour ;
}

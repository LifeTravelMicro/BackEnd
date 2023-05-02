package com.api.lifetravel.accommodations.resource;

import com.api.lifetravel.accommodations.domain.model.entity.Accommodation;
import com.api.lifetravel.transports.domain.model.entity.Transport;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccommodationImageResource {
    @NotNull
    @NotBlank
    private String path;

    @OneToOne
    @JoinColumn(name = "accommodation_id")
    private AccommodationResourceId accommodation;

}

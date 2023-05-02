package com.api.lifetravel.accommodations.resource;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccommodationConditionResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Create a new attribute for the returnDate
    @NotNull
    @NotBlank
    private String checkIn;

    // Create a new attribute for the returnDate
    @NotNull
    @NotBlank
    private String checkOut;

}

package com.api.lifetravel.accommodations.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conditions")
public class AccommodationCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String checkIn;

    @NotNull
    @NotBlank
    private String checkOut;


    @ManyToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;
}

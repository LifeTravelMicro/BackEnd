package com.api.lifetravel.payment.resource;


import com.api.lifetravel.trip_plan.resource.PlanResourceId;
import com.api.lifetravel.users.resource.TravelerResourceId;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class CreatePaymentResource {

    @NotNull
    @NotBlank
    private PlanResourceId plan;

    @NotNull
    @NotBlank
    private TravelerResourceId traveler;

    @NotNull
    @NotBlank
    private String price;

}

package com.api.lifetravel.payment.resource;


import com.api.lifetravel.trip_plan.resource.PlanResourceId;
import com.api.lifetravel.users.resource.TravelerResourceId;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResource {

    //delete id
    private Long id;
    private String price;
    private PlanResourceId plan;
    private TravelerResourceId traveler;


}

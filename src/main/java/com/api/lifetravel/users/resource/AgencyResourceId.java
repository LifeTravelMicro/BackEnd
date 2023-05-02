package com.api.lifetravel.users.resource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AgencyResourceId {
    private Long id;
    private String name;
}
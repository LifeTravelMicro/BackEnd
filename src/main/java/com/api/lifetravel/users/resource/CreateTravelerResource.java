package com.api.lifetravel.users.resource;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTravelerResource {

    @NotNull
    @NotBlank
    @Size(max= 60)
    @Column(unique = true)
    private String name;

    @Column(unique = true)
    @NotBlank
    @Size(max= 60)
    private String email;

    @Column
    @NotBlank
    @Size(min = 9, max = 9)
    private String phone;
}
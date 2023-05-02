package com.api.lifetravel.users.domain.model.entity;
import com.api.lifetravel.reviews.domain.model.entity.Review;
import com.api.lifetravel.transports.domain.model.entity.TransportImage;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "travelers")
public class Traveler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    @NotBlank
    @Size(max= 60)
    private String name;

    @Column(unique = true)
    @NotBlank
    @Size(max= 60)
    private String email;

    @Column
    @NotBlank
    @Size(min = 9, max = 9)
    private String phone;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany( mappedBy = "traveler", fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private List<Review> reviews;

}

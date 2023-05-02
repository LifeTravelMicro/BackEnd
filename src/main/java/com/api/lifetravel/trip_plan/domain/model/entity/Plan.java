package com.api.lifetravel.trip_plan.domain.model.entity;
import com.api.lifetravel.accommodations.domain.model.entity.Accommodation;
import com.api.lifetravel.reviews.domain.model.entity.Review;
import com.api.lifetravel.tours.domain.model.entity.Tour;
import com.api.lifetravel.transports.domain.model.entity.Transport;
import com.api.lifetravel.users.domain.model.entity.Agency;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table (name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Size(min=1,max= 31 )
    private String duration;

    @NotNull
    @NotBlank
    @Size(max=15)
    private String capacity;

    @NotNull
    @NotBlank
    private String thumbnail;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn (name = "agency_id")
    private Agency agency;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany( mappedBy = "plan", cascade = CascadeType.ALL)
    private List<Review> reviews;
}

package com.api.lifetravel.accommodations.domain.persistence;

import com.api.lifetravel.accommodations.domain.model.entity.AccommodationImage;
import com.api.lifetravel.transports.domain.model.entity.TransportImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationImageRepository extends JpaRepository<AccommodationImage, Long> {
}

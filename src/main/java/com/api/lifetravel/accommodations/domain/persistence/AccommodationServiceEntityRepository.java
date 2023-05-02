package com.api.lifetravel.accommodations.domain.persistence;
import com.api.lifetravel.accommodations.domain.model.entity.AccommodationServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationServiceEntityRepository extends JpaRepository<AccommodationServiceEntity, Long>{
}

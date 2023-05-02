package com.api.lifetravel.accommodations.domain.persistence;
import com.api.lifetravel.accommodations.domain.model.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{
}

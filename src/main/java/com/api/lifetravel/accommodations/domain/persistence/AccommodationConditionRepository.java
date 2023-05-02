package com.api.lifetravel.accommodations.domain.persistence;
import com.api.lifetravel.accommodations.domain.model.entity.AccommodationCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationConditionRepository extends JpaRepository<AccommodationCondition, Long>{
}

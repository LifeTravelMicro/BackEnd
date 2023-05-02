package com.api.lifetravel.trip_plan.domain.persistence;

import com.api.lifetravel.trip_plan.domain.model.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Long> { }

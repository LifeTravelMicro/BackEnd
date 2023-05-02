package com.api.lifetravel.trip_plan.domain.service;

import com.api.lifetravel.trip_plan.domain.model.entity.Plan;

import java.util.List;

public interface PlanService {

    List<Plan> getAll();

    Plan getPlanById(Long id);

    Plan create(Plan plan);

    Plan update(Long id, Plan planInput);

    Plan delete(Long id);

    List<Plan> insert(List<Plan> plans);
}

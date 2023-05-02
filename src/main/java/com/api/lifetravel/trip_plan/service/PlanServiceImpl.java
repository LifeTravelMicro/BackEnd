package com.api.lifetravel.trip_plan.service;

import com.api.lifetravel.shared.exception.ResourceValidationException;
import com.api.lifetravel.trip_plan.domain.model.entity.Plan;
import com.api.lifetravel.trip_plan.domain.persistence.PlanRepository;
import com.api.lifetravel.trip_plan.domain.service.PlanService;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PlanServiceImpl implements PlanService {
    private static final String ENTITY = "Plan";
    private final PlanRepository planRepository;
    private final Validator validator;

    @Override
    public List<Plan> getAll(){ return planRepository.findAll();}

    @Override
    public Plan getPlanById(Long id){ return planRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));}

    @Override
    public Plan create(Plan plan) {
        // Validating agency object
        Set<ConstraintViolation<Plan>> violations = validator.validate(plan);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return planRepository.save(plan);
    }

    @Override
    public Plan update(Long id, Plan planInput) {
        // Validating agency object
        Set<ConstraintViolation<Plan>> violations = validator.validate(planInput);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Plan plan = planRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        plan.setName(planInput.getName());
        plan.setDescription(planInput.getDescription());
        plan.setDuration(planInput.getDuration());
        plan.setCapacity(planInput.getCapacity());
        plan.setThumbnail(planInput.getThumbnail());

        return planRepository.save(plan);
    }

    @Override
    public Plan delete(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        planRepository.delete(plan);
        return plan;
    }

    @Override
    public List<Plan> insert(List<Plan> plans) {
        return planRepository.saveAll(plans);
    }
}

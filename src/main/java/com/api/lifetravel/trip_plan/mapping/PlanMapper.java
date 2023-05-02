package com.api.lifetravel.trip_plan.mapping;

import com.api.lifetravel.shared.mapping.EnhancedModelMapper;
import com.api.lifetravel.trip_plan.domain.model.entity.Plan;
import com.api.lifetravel.trip_plan.resource.CreatePlanResource;
import com.api.lifetravel.trip_plan.resource.PlanResource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class PlanMapper implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;
    public PlanMapper planMapper(){return new PlanMapper(modelMapper);}
    public Page<PlanResource>modelListPage(List<Plan>modelList, Pageable pageable){
        return new PageImpl<>(modelMapper.mapList(modelList, PlanResource.class), pageable, modelList.size());
    }

    public Plan toModel(CreatePlanResource resource){ return modelMapper.map(resource,Plan.class);}
    public PlanResource toResource(Plan plan){return modelMapper.map(plan,PlanResource.class);}


    public List<Plan> toModelList(List<CreatePlanResource> resources) {
        return modelMapper.mapList(resources, Plan.class);
    }

    public List<PlanResource> toResourceList(List<Plan> plans) {
        return modelMapper.mapList(plans, PlanResource.class);
    }
}

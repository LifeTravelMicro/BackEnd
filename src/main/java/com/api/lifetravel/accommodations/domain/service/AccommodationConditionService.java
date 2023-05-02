package com.api.lifetravel.accommodations.domain.service;


import com.api.lifetravel.accommodations.domain.model.entity.AccommodationCondition;

import java.util.List;

public interface AccommodationConditionService {
    List<AccommodationCondition> getAll();
    AccommodationCondition create(AccommodationCondition condition);
    AccommodationCondition update(Long id, AccommodationCondition condition);
    AccommodationCondition delete(Long id);
}

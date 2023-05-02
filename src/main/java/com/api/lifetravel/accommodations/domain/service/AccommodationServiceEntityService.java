package com.api.lifetravel.accommodations.domain.service;

import com.api.lifetravel.accommodations.domain.model.entity.AccommodationServiceEntity;
import java.util.List;

public interface AccommodationServiceEntityService {
    List<AccommodationServiceEntity> getAll();
    AccommodationServiceEntity create(AccommodationServiceEntity service);
    AccommodationServiceEntity update(Long id, AccommodationServiceEntity service);
    AccommodationServiceEntity delete(Long id);
}

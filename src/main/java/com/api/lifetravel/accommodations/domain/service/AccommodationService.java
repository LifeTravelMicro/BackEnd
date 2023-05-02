package com.api.lifetravel.accommodations.domain.service;


import com.api.lifetravel.accommodations.domain.model.entity.Accommodation;

import java.util.List;

public interface AccommodationService {
    List<Accommodation> getAll();
    Accommodation create(Accommodation accommodation);
    Accommodation getById(Long id);
    Accommodation update(Long id, Accommodation accommodation);
    Accommodation delete(Long id);
}

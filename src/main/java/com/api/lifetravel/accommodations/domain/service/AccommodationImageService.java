package com.api.lifetravel.accommodations.domain.service;

import com.api.lifetravel.accommodations.domain.model.entity.AccommodationImage;

import java.util.List;

public interface AccommodationImageService {
    List<AccommodationImage> getAll();
    AccommodationImage create(AccommodationImage image);

    AccommodationImage update(Long id, AccommodationImage image);

    AccommodationImage delete(Long id);
}

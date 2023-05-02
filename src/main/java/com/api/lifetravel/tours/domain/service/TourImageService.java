package com.api.lifetravel.tours.domain.service;

import com.api.lifetravel.tours.domain.model.entity.TourImage;

import java.util.List;

public interface TourImageService {
    List<TourImage> getAll();

    TourImage create(TourImage image);

    TourImage update(Long id, TourImage image);

    TourImage delete(Long id);
}

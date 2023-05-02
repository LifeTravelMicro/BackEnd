package com.api.lifetravel.tours.domain.service;

import com.api.lifetravel.tours.domain.model.entity.Tour;

import java.util.List;

public interface TourService {

    List<Tour>getAll();
    Tour create(Tour tour);

    Tour getById(Long id);
    Tour update(Long id , Tour tour);
    Tour delete(Long id);

}

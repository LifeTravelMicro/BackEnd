package com.api.lifetravel.tours.service;

import com.api.lifetravel.shared.exception.ResourceValidationException;
import com.api.lifetravel.tours.domain.model.entity.Tour;
import com.api.lifetravel.tours.domain.persistence.TourRepository;
import com.api.lifetravel.tours.domain.service.TourService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TourServiceImpl implements TourService {
    private static final String ENTITY = "Tour";
    private final TourRepository tourRepository;
    private final Validator validator;

    // create the getAll method for the Transport

    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getById(Long id) {
        return tourRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
    }

    // create the create method for the Transport
    @Override
    public Tour create(Tour tour) {
        Set<ConstraintViolation<Tour>> violations = validator.validate(tour);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return tourRepository.save(tour);
    }

    // create the update method for the Transport
    @Override
    public Tour update(Long id,Tour tour) {
        Set<ConstraintViolation<Tour>> violations = validator.validate(tour);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Tour tour1 = tourRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        tour1.setAgency(tour.getAgency());
        tour1.setPrice(tour.getPrice());
        tour1.setDetails(tour.getDetails());
        tour1.setLocation(tour.getLocation());
        tour1.setMeetingPoint(tour.getMeetingPoint());

        return tourRepository.save(tour1);
    }

    // create the delete method for the Transport
    @Override
    public Tour delete(Long id) {
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        tourRepository.delete(tour);
        return tour;
    }
}

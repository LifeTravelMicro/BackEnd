package com.api.lifetravel.tours.service;

import com.api.lifetravel.shared.exception.ResourceValidationException;
import com.api.lifetravel.tours.domain.model.entity.TourImage;
import com.api.lifetravel.tours.domain.persistence.TourImageRepository;
import com.api.lifetravel.tours.domain.service.TourImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TourImageServiceImpl implements TourImageService {

    private static final String ENTITY = "TourImage";
    private final TourImageRepository tourRepository;
    private final Validator validator;

    @Override
    public List<TourImage> getAll() {
        return tourRepository.findAll();
    }

    @Override
    public TourImage create(TourImage image) {
        Set<ConstraintViolation<TourImage>> violations = validator.validate(image);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return tourRepository.save(image);
    }
    @Override
    public TourImage update(Long id, TourImage image) {
        Set<ConstraintViolation<TourImage>> violations = validator.validate(image);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }
        TourImage image1 = tourRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        image1.setPath(image.getPath());
        image1.setTour(image.getTour());

        return tourRepository.save(image1);
    }
    @Override
    public TourImage delete(Long id) {
        TourImage image = tourRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        tourRepository.delete(image);
        return image;
    }


}

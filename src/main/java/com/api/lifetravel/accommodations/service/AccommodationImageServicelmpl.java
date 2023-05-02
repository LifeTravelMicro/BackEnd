package com.api.lifetravel.accommodations.service;

import com.api.lifetravel.shared.exception.ResourceValidationException;
import com.api.lifetravel.accommodations.domain.model.entity.AccommodationImage;
import com.api.lifetravel.accommodations.domain.persistence.AccommodationImageRepository;
import com.api.lifetravel.accommodations.domain.service.AccommodationImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccommodationImageServicelmpl implements AccommodationImageService {

    private static final String ENTITY = "AccommodationImage";
    private final AccommodationImageRepository accommodationRepository;
    private final Validator validator;

    // create the getAll method
    @Override
    public List<AccommodationImage> getAll() {
        return accommodationRepository.findAll();
    }

    // create the create method
    @Override
    public AccommodationImage create(AccommodationImage image) {
        Set<ConstraintViolation<AccommodationImage>> violations = validator.validate(image);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return accommodationRepository.save(image);
    }

    // create the update method
    @Override
    public AccommodationImage update(Long id, AccommodationImage image) {
        Set<ConstraintViolation<AccommodationImage>> violations = validator.validate(image);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        AccommodationImage image1 = accommodationRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        image1.setPath(image.getPath());
        image1.setAccommodation(image.getAccommodation());

        return accommodationRepository.save(image1);
    }

    // create the delete method
    @Override
    public AccommodationImage delete(Long id) {
        AccommodationImage image = accommodationRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        accommodationRepository.delete(image);
        return image;
    }

}

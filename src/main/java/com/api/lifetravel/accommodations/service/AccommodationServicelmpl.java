package com.api.lifetravel.accommodations.service;

import com.api.lifetravel.accommodations.domain.model.entity.Accommodation;
import com.api.lifetravel.accommodations.domain.persistence.AccommodationRepository;
import com.api.lifetravel.accommodations.domain.service.AccommodationService;
import com.api.lifetravel.shared.exception.ResourceValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccommodationServicelmpl implements AccommodationService {

    private static final String ENTITY = "Accommodation";
    private final AccommodationRepository accommodationRepository;
    private final Validator validator;

    // create the getAll method for the Accommodation
    @Override
    public List<Accommodation> getAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation getById(Long id) {
        return accommodationRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
    }

    // create the create method for the Transport
    @Override
    public Accommodation create(Accommodation accommodation) {
        Set<ConstraintViolation<Accommodation>> violations = validator.validate(accommodation);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return accommodationRepository.save(accommodation);
    }

    // create the update method for the Transport
    @Override
    public Accommodation update(Long id, Accommodation accommodation) {
        Set<ConstraintViolation<Accommodation>> violations = validator.validate(accommodation);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Accommodation accommodation1 = accommodationRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        accommodation1.setDetails(accommodation.getDetails());
        accommodation1.setPrice(accommodation.getPrice());
        accommodation1.setLocation(accommodation.getLocation());
        accommodation1.setPrice(accommodation.getPrice());

        return accommodationRepository.save(accommodation1);
    }

    // create the delete method for the Transport
    @Override
    public Accommodation delete(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        accommodationRepository.delete(accommodation);
        return accommodation;
    }
}

package com.api.lifetravel.accommodations.service;

import com.api.lifetravel.accommodations.domain.persistence.AccommodationServiceEntityRepository;
import com.api.lifetravel.accommodations.domain.service.AccommodationServiceEntityService;
import com.api.lifetravel.accommodations.domain.model.entity.AccommodationServiceEntity;
import com.api.lifetravel.shared.exception.ResourceValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccommodationServiceEntityServicelmpl implements AccommodationServiceEntityService {

    private static final String ENTITY = "AccommodationServiceEntity";

    private final AccommodationServiceEntityRepository accommodationServiceEntityRepository;
    private final Validator validator;

    @Override
    public List<AccommodationServiceEntity> getAll() {
        return accommodationServiceEntityRepository.findAll();
    }

    @Override
    public AccommodationServiceEntity create(AccommodationServiceEntity accommodationService) {
        Set<ConstraintViolation<AccommodationServiceEntity>> violations = validator.validate(accommodationService);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return accommodationServiceEntityRepository.save(accommodationService);
    }

    @Override
    public AccommodationServiceEntity update(Long id, AccommodationServiceEntity service) {
        Set<ConstraintViolation<AccommodationServiceEntity>> violations = validator.validate(service);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        AccommodationServiceEntity service1 = accommodationServiceEntityRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        return accommodationServiceEntityRepository.save(service1);
    }

    @Override
    public AccommodationServiceEntity delete(Long id) {
        AccommodationServiceEntity transport = accommodationServiceEntityRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        accommodationServiceEntityRepository.delete(transport);
        return transport;
    }
}

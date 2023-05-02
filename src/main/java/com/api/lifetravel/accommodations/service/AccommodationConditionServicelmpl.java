package com.api.lifetravel.accommodations.service;

import com.api.lifetravel.accommodations.domain.model.entity.AccommodationCondition;
import com.api.lifetravel.accommodations.domain.persistence.AccommodationConditionRepository;
import com.api.lifetravel.accommodations.domain.service.AccommodationConditionService;
import com.api.lifetravel.shared.exception.ResourceValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccommodationConditionServicelmpl implements AccommodationConditionService {

    private static final String ENTITY = "AccommodationCondition";
    private final AccommodationConditionRepository accommodationConditionRepository;
    private final Validator validator;

    // create the getAll method for the Transport
    @Override
    public List<AccommodationCondition> getAll() {
        return accommodationConditionRepository.findAll();
    }

    // create the create method for the Transport
    @Override
    public AccommodationCondition create(AccommodationCondition transport) {
        Set<ConstraintViolation<AccommodationCondition>> violations = validator.validate(transport);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return accommodationConditionRepository.save(transport);
    }

    // create the update method for the Transport
    @Override
    public AccommodationCondition update(Long id, AccommodationCondition transport) {
        Set<ConstraintViolation<AccommodationCondition>> violations = validator.validate(transport);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        AccommodationCondition accommodationCondition = accommodationConditionRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        accommodationCondition.setCheckIn(transport.getCheckIn());
        accommodationCondition.setCheckOut(transport.getCheckOut());

        return accommodationConditionRepository.save(accommodationCondition);
    }

    // create the delete method for the Transport
    @Override
    public AccommodationCondition delete(Long id) {
        AccommodationCondition accommodationCondition = accommodationConditionRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        accommodationConditionRepository.delete(accommodationCondition);
        return accommodationCondition;
    }
}

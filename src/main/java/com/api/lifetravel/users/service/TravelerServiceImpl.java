package com.api.lifetravel.users.service;

import com.api.lifetravel.shared.exception.ResourceValidationException;
import com.api.lifetravel.users.domain.model.entity.Traveler;
import com.api.lifetravel.users.domain.persistence.TravelerRepository;
import com.api.lifetravel.users.domain.service.TravelerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TravelerServiceImpl implements TravelerService{

    private static final String ENTITY = "Traveler";
    private final TravelerRepository travelerRepository;
    private final Validator validator;

    @Override
    public List<Traveler> getAll() {
        return travelerRepository.findAll();
    }

    @Override
    public Traveler getById(Long id) {
        return travelerRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
    }

    @Override
    public Traveler create(Traveler traveler) {
        // Validating traveler object
        Set<ConstraintViolation<Traveler>> violations = validator.validate(traveler);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return travelerRepository.save(traveler);
    }

    @Override
    public Traveler update(Long id, Traveler travelerInput) {
        // Validating traveler object
        Set<ConstraintViolation<Traveler>> violations = validator.validate(travelerInput);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Traveler traveler = travelerRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        traveler.setName(travelerInput.getName());
        traveler.setEmail(travelerInput.getEmail());
        traveler.setPhone(travelerInput.getPhone());

        return travelerRepository.save(traveler);
    }

    @Override
    public Traveler delete(Long id) {
        Traveler traveler = travelerRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        travelerRepository.delete(traveler);
        return traveler;
    }

}

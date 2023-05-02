package com.api.lifetravel.users.service;

import com.api.lifetravel.shared.exception.ResourceValidationException;
import com.api.lifetravel.users.domain.model.entity.Agency;
import com.api.lifetravel.users.domain.persistence.AgencyRepository;
import com.api.lifetravel.users.domain.service.AgencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AgencyServiceImpl implements AgencyService{

    private static final String ENTITY = "Agency";
    private final AgencyRepository agencyRepository;
    private final Validator validator;

    @Override
    public List<Agency> getAll() {
        return agencyRepository.findAll();
    }

    @Override
    public Agency getAgencyById(Long id) {
        return agencyRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
    }

    @Override
    public Agency create(Agency agency) {
        // Validating agency object
        Set<ConstraintViolation<Agency>> violations = validator.validate(agency);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return agencyRepository.save(agency);
    }

    @Override
    public Agency update(Long id, Agency agencyInput) {
        // Validating agency object
        Set<ConstraintViolation<Agency>> violations = validator.validate(agencyInput);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Agency agency = agencyRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        agency.setName(agencyInput.getName());
        agency.setEmail(agencyInput.getEmail());
        agency.setRuc(agencyInput.getRuc());

        return agencyRepository.save(agency);
    }

    @Override
    public Agency delete(Long id) {
        Agency agency = agencyRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        agencyRepository.delete(agency);
        return agency;
    }

}

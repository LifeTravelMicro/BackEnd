package com.api.lifetravel.transports.service;

import com.api.lifetravel.shared.exception.ResourceValidationException;
import com.api.lifetravel.transports.domain.model.entity.Transport;
import com.api.lifetravel.transports.domain.persistence.TransportRepository;
import com.api.lifetravel.transports.domain.service.TransportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TransportServicelmpl implements TransportService {

    private static final String ENTITY = "Transport";
    private final TransportRepository transportRepository;
    private final Validator validator;

    // create the getAll method for the Transport
    @Override
    public List<Transport> getAll() {
        return transportRepository.findAll();
    }

    @Override
    public Transport getById(Long id) {
        return transportRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
    }

    // create the create method for the Transport
    @Override
    public Transport create(Transport transport) {
        Set<ConstraintViolation<Transport>> violations = validator.validate(transport);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return transportRepository.save(transport);
    }

    // create the update method for the Transport
    @Override
    public Transport update(Long id,Transport transport) {
        Set<ConstraintViolation<Transport>> violations = validator.validate(transport);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Transport transport1 = transportRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        transport1.setType(transport.getType());
        transport1.setSeats(transport.getSeats());
        transport1.setDepartureDate(transport.getDepartureDate());
        transport1.setReturnDate(transport.getReturnDate());
        transport1.setPrice(transport.getPrice());
        transport1.setPlan(transport.getPlan());

        return transportRepository.save(transport1);
    }

    // create the delete method for the Transport
    @Override
    public Transport delete(Long id) {
        Transport transport = transportRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        transportRepository.delete(transport);
        return transport;
    }
}

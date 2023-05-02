package com.api.lifetravel.transports.service;

import com.api.lifetravel.shared.exception.ResourceValidationException;
import com.api.lifetravel.transports.domain.model.entity.TransportImage;
import com.api.lifetravel.transports.domain.persistence.TransportImageRepository;
import com.api.lifetravel.transports.domain.service.TransportImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TransportImageServicelmpl implements TransportImageService {

    private static final String ENTITY = "TransportImage";
    private final TransportImageRepository transportRepository;
    private final Validator validator;

    // create the getAll method
    @Override
    public List<TransportImage> getAll() {
        return transportRepository.findAll();
    }

    // create the create method
    @Override
    public TransportImage create(TransportImage image) {
        Set<ConstraintViolation<TransportImage>> violations = validator.validate(image);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return transportRepository.save(image);
    }

    // create the update method
    @Override
    public TransportImage update(Long id, TransportImage image) {
        Set<ConstraintViolation<TransportImage>> violations = validator.validate(image);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        TransportImage image1 = transportRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        image1.setPath(image.getPath());
        image1.setTransport(image.getTransport());

        return transportRepository.save(image1);
    }

    // create the delete method
    @Override
    public TransportImage delete(Long id) {
        TransportImage image = transportRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        transportRepository.delete(image);
        return image;
    }

}

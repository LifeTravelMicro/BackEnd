package com.api.lifetravel.payment.service;

import com.api.lifetravel.payment.domain.model.entity.Payment;
import com.api.lifetravel.payment.domain.persistence.PaymentRepository;
import com.api.lifetravel.payment.domain.service.PaymentService;

import com.api.lifetravel.shared.exception.ResourceValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private static final String ENTITY = "Payment";
    private final PaymentRepository paymentRepository;
    private final Validator validator;

    @Override
    public List<Payment> getAll(){ return paymentRepository.findAll();}

    @Override
    public Payment create(Payment payment) {
        // Validating agency object
        Set<ConstraintViolation<Payment>> violations =validator.validate(payment);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Long id, Payment paymentInput) {
        // Validating agency object
        Set<ConstraintViolation<Payment>> violations = validator.validate(paymentInput);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));

        payment.setPrice(paymentInput.getPrice());

        return paymentRepository.save(payment);
    }

    @Override
    public Payment delete(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceValidationException(ENTITY, "id", id));
        paymentRepository.delete(payment);
        return payment;
    }




}

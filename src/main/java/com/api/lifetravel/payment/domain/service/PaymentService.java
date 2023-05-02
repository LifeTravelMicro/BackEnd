package com.api.lifetravel.payment.domain.service;
import com.api.lifetravel.payment.domain.model.entity.Payment;
import java.util.List;

public interface PaymentService {

    List<Payment> getAll();
    Payment create(Payment payment);

    Payment update(Long id, Payment paymentInput);

    Payment delete(Long id);

}

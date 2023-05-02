package com.api.lifetravel.payment.domain.persistence;

import com.api.lifetravel.payment.domain.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {


}

package com.api.lifetravel.payment.mapping;

import com.api.lifetravel.shared.mapping.EnhancedModelMapper;
import com.api.lifetravel.payment.domain.model.entity.Payment;
import com.api.lifetravel.payment.resource.CreatePaymentResource;
import com.api.lifetravel.payment.resource.PaymentResource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class PaymentMapper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
   private EnhancedModelMapper modelMapper;

    public PaymentMapper paymentMapper(){return new PaymentMapper(modelMapper);}
    public Page<PaymentResource> modelListPage(List<Payment> modelList, Pageable pageable){
        return new PageImpl<>(modelMapper.mapList(modelList, PaymentResource.class), pageable, modelList.size());
    }

    public Payment toModel(CreatePaymentResource resource){ return modelMapper.map(resource,Payment.class);}
    public PaymentResource toResource(Payment payment){return modelMapper.map(payment,PaymentResource.class);}



}

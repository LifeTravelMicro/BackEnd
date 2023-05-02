package com.api.lifetravel.payment.api;
import com.api.lifetravel.payment.domain.model.entity.Payment;
import com.api.lifetravel.payment.domain.service.PaymentService;
import com.api.lifetravel.payment.mapping.PaymentMapper;
import com.api.lifetravel.payment.resource.CreatePaymentResource;
import com.api.lifetravel.payment.resource.PaymentResource;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD})
@RestController
@RequestMapping(value = "api/v1/payments", produces = "application/json")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @GetMapping
    @Operation(summary = "Get all payments")
    public Page<PaymentResource> getAllPayments(@ParameterObject Pageable pageable){
        return paymentMapper.modelListPage(paymentService.getAll(),pageable);
    }

    @PostMapping
    @Operation(summary = "Create a payment")
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource resource){
        Payment paymentInput = paymentMapper.toModel(resource);
        Payment paymentSaved = paymentService.create(paymentInput);
        PaymentResource paymentResource = paymentMapper.toResource(paymentSaved);
        return new ResponseEntity<>(paymentResource , HttpStatus.CREATED);//201
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a payment")
    public ResponseEntity<PaymentResource> updatePayment(@PathVariable Long id, @RequestBody CreatePaymentResource resource) {
        Payment paymentInput = paymentMapper.toModel(resource);
        Payment paymentSaved = paymentService.update(id, paymentInput);
        PaymentResource paymentResource = paymentMapper.toResource(paymentSaved);
        return new ResponseEntity<>(paymentResource, HttpStatus.OK); // 200
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a payment")
    public ResponseEntity<PaymentResource> deletePayment(@PathVariable Long id) {
        Payment payment = paymentService.delete(id);
        PaymentResource paymentResource = paymentMapper.toResource(payment);
        return new ResponseEntity<>(paymentResource, HttpStatus.OK); // 200
    }


}

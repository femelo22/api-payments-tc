package com.br.lfmelo.adapters.driven.repository.impl;

import com.br.lfmelo.adapters.driven.entities.PaymentEntity;
import com.br.lfmelo.adapters.driven.repository.SpringPaymentRepository;
import com.br.lfmelo.adapters.mappers.PaymentMapper;
import com.br.lfmelo.core.model.Payment;
import com.br.lfmelo.core.ports.PaymentRepositoryPort;
import com.br.lfmelo.infrastructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentRepository implements PaymentRepositoryPort {

    @Autowired
    private SpringPaymentRepository springPaymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment update(Payment payment) {
        PaymentEntity paymentEntityToUpdate = paymentMapper.paymentToPaymentEntity(payment);
        PaymentEntity paymentntityUpdated = this.springPaymentRepository.save(paymentEntityToUpdate);
        return paymentMapper.paymentEntityToPayment(paymentntityUpdated);
    }

    @Override
    public Payment findByOrderId(Long orderId) {
        PaymentEntity paymentEntity = springPaymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new NotFoundException(String.format("Payment with Order Id = %s not found!", orderId)));
        return paymentMapper.paymentEntityToPayment(paymentEntity);
    }

    @Override
    public Payment createPayment(Payment payment) {
        PaymentEntity paymentEntityToUpdate = paymentMapper.paymentToPaymentEntity(payment);
        PaymentEntity newPayment = this.springPaymentRepository.save(paymentEntityToUpdate);
        return paymentMapper.paymentEntityToPayment(newPayment);
    }
}

package com.br.lfmelo.adapters.driven.repository.impl;

import com.br.lfmelo.adapters.driven.entities.PaymentEntity;
import com.br.lfmelo.adapters.driven.repository.SpringPaymentRepository;
import com.br.lfmelo.adapters.mappers.PaymentMapper;
import com.br.lfmelo.core.model.Payment;
import com.br.lfmelo.core.ports.PaymentRepositoryPort;
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
        return  paymentMapper.paymentEntityToPayment(paymentntityUpdated);
    }
}

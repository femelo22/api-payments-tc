package com.br.lfmelo.application.services;

import com.br.lfmelo.core.model.Payment;
import com.br.lfmelo.core.ports.PaymentRepositoryPort;
import com.br.lfmelo.core.ports.PaymentServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentServicePort {

    @Autowired
    PaymentRepositoryPort repository;

    @Override
    public Payment updatePayment(Payment payment) {
        return repository.update(payment);
    }
}

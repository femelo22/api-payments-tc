package com.br.lfmelo.core.ports;

import com.br.lfmelo.core.model.Payment;

public interface PaymentRepositoryPort {
    Payment update(Payment payment);
    Payment findByOrderId(Long idPayment);
    Payment createPayment(Payment payment);
}

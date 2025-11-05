package com.br.lfmelo.core.ports;

import com.br.lfmelo.core.model.Payment;

public interface PaymentServicePort {
    Payment updatePayment(Payment payment);
}

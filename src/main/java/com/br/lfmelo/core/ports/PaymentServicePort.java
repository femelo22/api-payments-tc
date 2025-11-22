package com.br.lfmelo.core.ports;

import com.br.lfmelo.adapters.dtos.order.OrderDTO;
import com.br.lfmelo.core.model.Payment;
import com.br.lfmelo.core.model.enums.PaymentStatus;
import com.br.lfmelo.core.model.enums.PaymentType;

public interface PaymentServicePort {
    String gerarQrCode(OrderDTO orderDTO);
    void updatePaymentByOrderId(String externalReference, PaymentStatus paymentStatus);
    Payment getPaymentByOrderId(Long idPayment);
    Payment createPaymentWithQrCode(OrderDTO orderDTO, PaymentType paymentType);
}

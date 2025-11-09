package com.br.lfmelo.core.ports;

import com.br.lfmelo.adapters.dtos.order.OrderDTO;

public interface PaymentServicePort {
    String gerarQrCode(OrderDTO orderDTO);
}

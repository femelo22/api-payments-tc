package com.br.lfmelo.adapters.dtos.order;

import com.br.lfmelo.core.model.Order;
import com.br.lfmelo.core.model.enums.PaymentType;

public record OrderPayment(PaymentType paymentType, Order order) {
}

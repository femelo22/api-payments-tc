package com.br.lfmelo.adapters.mappers;

import com.br.lfmelo.adapters.driven.entities.PaymentEntity;
import com.br.lfmelo.core.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentEntity paymentToPaymentEntity(Payment payment);

    @Mapping(target = "orderId", ignore = true)
    Payment paymentEntityToPayment(PaymentEntity paymentEntity);
}

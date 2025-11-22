package com.br.lfmelo.adapters.mappers;

import com.br.lfmelo.adapters.driven.entities.PaymentEntity;
import com.br.lfmelo.core.model.Payment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-22T12:04:10-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentEntity paymentToPaymentEntity(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentEntity paymentEntity = new PaymentEntity();

        paymentEntity.setId( payment.getId() );
        paymentEntity.setOrderId( payment.getOrderId() );
        paymentEntity.setType( payment.getType() );
        paymentEntity.setStatus( payment.getStatus() );
        paymentEntity.setQrCode( payment.getQrCode() );

        return paymentEntity;
    }

    @Override
    public Payment paymentEntityToPayment(PaymentEntity paymentEntity) {
        if ( paymentEntity == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId( paymentEntity.getId() );
        payment.setType( paymentEntity.getType() );
        payment.setStatus( paymentEntity.getStatus() );
        payment.setQrCode( paymentEntity.getQrCode() );

        return payment;
    }
}

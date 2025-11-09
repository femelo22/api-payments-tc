package com.br.lfmelo.adapters.mappers;

import com.br.lfmelo.adapters.driven.entities.PaymentEntity;
import com.br.lfmelo.core.model.Payment;
import com.br.lfmelo.core.model.enums.PaymentStatus;
import com.br.lfmelo.core.model.enums.PaymentType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-09T14:33:12-0300",
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

        Long id = null;
        PaymentType type = null;
        PaymentStatus status = null;
        String qrCode = null;

        id = paymentEntity.getId();
        type = paymentEntity.getType();
        status = paymentEntity.getStatus();
        qrCode = paymentEntity.getQrCode();

        Long orderId = null;

        Payment payment = new Payment( id, orderId, type, status, qrCode );

        return payment;
    }
}

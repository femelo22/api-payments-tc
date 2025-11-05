package com.br.lfmelo.adapters.mappers;

import com.br.lfmelo.adapters.driven.entities.ClientEntity;
import com.br.lfmelo.adapters.driven.entities.OrderEntity;
import com.br.lfmelo.adapters.driven.entities.OrderItemEntity;
import com.br.lfmelo.adapters.driven.entities.PaymentEntity;
import com.br.lfmelo.adapters.driven.entities.ProductEntity;
import com.br.lfmelo.core.model.Client;
import com.br.lfmelo.core.model.Order;
import com.br.lfmelo.core.model.OrderItem;
import com.br.lfmelo.core.model.Payment;
import com.br.lfmelo.core.model.Product;
import com.br.lfmelo.core.model.enums.PaymentStatus;
import com.br.lfmelo.core.model.enums.PaymentType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-05T19:04:48-0300",
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
        paymentEntity.setOrder( orderToOrderEntity( payment.getOrder() ) );
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

        PaymentType type = null;
        PaymentStatus status = null;
        String qrCode = null;
        Long id = null;

        type = paymentEntity.getType();
        status = paymentEntity.getStatus();
        qrCode = paymentEntity.getQrCode();
        id = paymentEntity.getId();

        Order order = null;

        Payment payment = new Payment( id, order, type, status, qrCode );

        return payment;
    }

    protected ClientEntity clientToClientEntity(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId( client.getId() );
        clientEntity.setCpf( client.getCpf() );
        clientEntity.setName( client.getName() );
        clientEntity.setEmail( client.getEmail() );
        clientEntity.setPhone( client.getPhone() );
        clientEntity.setCreatedAt( client.getCreatedAt() );
        clientEntity.setUpdatedAt( client.getUpdatedAt() );

        return clientEntity;
    }

    protected ProductEntity productToProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setCategory( product.getCategory() );
        productEntity.setName( product.getName() );
        productEntity.setPrice( product.getPrice() );
        productEntity.setDescription( product.getDescription() );
        productEntity.setActive( product.getActive() );
        productEntity.setCreatedAt( product.getCreatedAt() );
        productEntity.setUpdatedAt( product.getUpdatedAt() );

        return productEntity;
    }

    protected OrderItemEntity orderItemToOrderItemEntity(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemEntity orderItemEntity = new OrderItemEntity();

        orderItemEntity.setId( orderItem.getId() );
        orderItemEntity.setOrder( orderToOrderEntity( orderItem.getOrder() ) );
        orderItemEntity.setProduct( productToProductEntity( orderItem.getProduct() ) );
        orderItemEntity.setAmount( orderItem.getAmount() );
        orderItemEntity.setUnitPrice( orderItem.getUnitPrice() );
        orderItemEntity.setNotes( orderItem.getNotes() );

        return orderItemEntity;
    }

    protected List<OrderItemEntity> orderItemListToOrderItemEntityList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemEntity> list1 = new ArrayList<OrderItemEntity>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemToOrderItemEntity( orderItem ) );
        }

        return list1;
    }

    protected OrderEntity orderToOrderEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( order.getId() );
        orderEntity.setClient( clientToClientEntity( order.getClient() ) );
        orderEntity.setCpf( order.getCpf() );
        orderEntity.setStatus( order.getStatus() );
        orderEntity.setTotalPrice( order.getTotalPrice() );
        orderEntity.setDate( order.getDate() );
        orderEntity.setPayment( paymentToPaymentEntity( order.getPayment() ) );
        orderEntity.setItems( orderItemListToOrderItemEntityList( order.getItems() ) );

        return orderEntity;
    }
}

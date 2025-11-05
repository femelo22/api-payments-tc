package com.br.lfmelo.adapters.mappers;

import com.br.lfmelo.adapters.driven.entities.OrderEntity;
import com.br.lfmelo.adapters.driven.entities.OrderItemEntity;
import com.br.lfmelo.adapters.driven.entities.ProductEntity;
import com.br.lfmelo.core.model.Order;
import com.br.lfmelo.core.model.OrderItem;
import com.br.lfmelo.core.model.Product;
import com.br.lfmelo.core.model.enums.ProductCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-05T19:04:48-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl extends OrderMapper {

    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public OrderEntity orderToOrderEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( order.getId() );
        orderEntity.setClient( clientMapper.clientToClientEntity( order.getClient() ) );
        orderEntity.setCpf( order.getCpf() );
        orderEntity.setStatus( order.getStatus() );
        orderEntity.setTotalPrice( order.getTotalPrice() );
        orderEntity.setDate( order.getDate() );
        orderEntity.setPayment( paymentMapper.paymentToPaymentEntity( order.getPayment() ) );
        orderEntity.setItems( orderItemListToOrderItemEntityList( order.getItems() ) );

        return orderEntity;
    }

    @Override
    public Order orderEntityToOrder(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderEntity.getId() );
        order.setClient( clientMapper.clientEntityToClient( orderEntity.getClient() ) );
        order.setCpf( orderEntity.getCpf() );
        order.setStatus( orderEntity.getStatus() );
        order.setTotalPrice( orderEntity.getTotalPrice() );
        order.setDate( orderEntity.getDate() );
        order.setPayment( paymentMapper.paymentEntityToPayment( orderEntity.getPayment() ) );
        order.setItems( orderItemEntityListToOrderItemList( orderEntity.getItems() ) );

        return order;
    }

    @Override
    public OrderItem orderItemEntityToOrderItem(OrderItemEntity orderItemEntity) {
        if ( orderItemEntity == null ) {
            return null;
        }

        Long id = null;
        Product product = null;
        Integer amount = null;
        BigDecimal unitPrice = null;
        String notes = null;

        id = orderItemEntity.getId();
        product = productEntityToProduct( orderItemEntity.getProduct() );
        amount = orderItemEntity.getAmount();
        unitPrice = orderItemEntity.getUnitPrice();
        notes = orderItemEntity.getNotes();

        Order order = null;

        OrderItem orderItem = new OrderItem( id, order, product, amount, unitPrice, notes );

        return orderItem;
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

    protected List<OrderItem> orderItemEntityListToOrderItemList(List<OrderItemEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemEntity orderItemEntity : list ) {
            list1.add( orderItemEntityToOrderItem( orderItemEntity ) );
        }

        return list1;
    }

    protected Product productEntityToProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Long id = null;
        ProductCategory category = null;
        String name = null;
        BigDecimal price = null;
        String description = null;
        Boolean active = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = productEntity.getId();
        category = productEntity.getCategory();
        name = productEntity.getName();
        price = productEntity.getPrice();
        description = productEntity.getDescription();
        active = productEntity.getActive();
        createdAt = productEntity.getCreatedAt();
        updatedAt = productEntity.getUpdatedAt();

        Product product = new Product( id, category, name, price, description, active, createdAt, updatedAt );

        return product;
    }
}

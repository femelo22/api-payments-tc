//package com.br.lfmelo.adapters.mappers;
//
//import com.br.lfmelo.core.model.Order;
//import com.br.lfmelo.core.model.OrderItem;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(componentModel = "spring", uses = {PaymentMapper.class, ClientMapper.class})
//public abstract class OrderMapper {
//
//    public abstract OrderEntity orderToOrderEntity(Order order);
//
//    public abstract Order orderEntityToOrder(OrderEntity orderEntity);
//
//    @Mapping(target = "order", ignore = true)
//    public abstract OrderItem orderItemEntityToOrderItem(OrderItemEntity orderItemEntity);
//}
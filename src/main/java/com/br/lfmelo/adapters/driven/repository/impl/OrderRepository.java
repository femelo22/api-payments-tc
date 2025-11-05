package com.br.lfmelo.adapters.driven.repository.impl;

import com.br.lfmelo.adapters.driven.entities.OrderEntity;
import com.br.lfmelo.adapters.driven.repository.SpringOrderRepository;
import com.br.lfmelo.adapters.mappers.ClientMapper;
import com.br.lfmelo.adapters.mappers.OrderMapper;
import com.br.lfmelo.adapters.mappers.PaymentMapper;
import com.br.lfmelo.core.model.Client;
import com.br.lfmelo.core.model.Order;
import com.br.lfmelo.core.model.Payment;
import com.br.lfmelo.core.ports.OrderRepositoryPort;
import com.br.lfmelo.infrastructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository implements OrderRepositoryPort {

    @Autowired
    private SpringOrderRepository springOrderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Order findByIdOrder(Long id) {
        OrderEntity orderEntity = springOrderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Order id %s not found!", id)));

        return orderMapper.orderEntityToOrder(orderEntity);
    }

    @Override
    public void save(Order order) {
        OrderEntity orderEntity = orderMapper.orderToOrderEntity(order);
        springOrderRepository.save(orderEntity);
    }
}

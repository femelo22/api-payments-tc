//package com.br.lfmelo.application.services;
//
//import com.br.lfmelo.core.model.Order;
//import com.br.lfmelo.core.ports.OrderRepositoryPort;
//import com.br.lfmelo.core.ports.OrderServicePort;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrderServiceImpl implements OrderServicePort {
//
//    @Autowired
//    private OrderRepositoryPort orderRepositoryPort;
//
//    @Override
//    public Order findById(Long id) {
//        return orderRepositoryPort.findByIdOrder(id);
//    }
//
//    @Override
//    public void save(Order order) {
//        orderRepositoryPort.save(order);
//    }
//}

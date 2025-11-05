package com.br.lfmelo.core.ports;

import com.br.lfmelo.core.model.Order;

public interface OrderServicePort {
    Order findById(Long id);
    void save(Order order);
}

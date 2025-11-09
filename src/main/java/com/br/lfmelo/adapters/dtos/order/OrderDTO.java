package com.br.lfmelo.adapters.dtos.order;

import com.br.lfmelo.core.model.OrderItem;
import com.br.lfmelo.core.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        Long id,
        Long clientId,
        String cpf,
        OrderStatus status,
        BigDecimal totalPrice,
        LocalDateTime date,
        List<OrderItem> items) {


}


package com.br.lfmelo.adapters.dtos.order;

import com.br.lfmelo.adapters.dtos.product.ProductDTO;
import com.br.lfmelo.core.model.OrderItem;

import java.math.BigDecimal;

public record OrderItemDTO(ProductDTO product, Integer amount, BigDecimal unitPrice, String notes) {

    public static OrderItemDTO fromItem(OrderItem orderItem){
        return new OrderItemDTO(ProductDTO.fromProduct(orderItem.getProduct()), orderItem.getAmount(), orderItem.getUnitPrice(), orderItem.getNotes());
    }
}

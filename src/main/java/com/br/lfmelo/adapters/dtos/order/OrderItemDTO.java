package com.br.lfmelo.adapters.dtos.order;

import com.br.lfmelo.adapters.dtos.product.ProductDTO;

import java.math.BigDecimal;

public record OrderItemDTO(ProductDTO product, Integer amount, BigDecimal unitPrice, String notes) {
}

package com.br.lfmelo.adapters.dtos.product;

import com.br.lfmelo.core.model.enums.ProductCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductDTO(
    Long id,
    ProductCategory category,
    String name,
    BigDecimal price,
    String description,
    Boolean active,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {
}

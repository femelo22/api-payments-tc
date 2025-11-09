package com.br.lfmelo.adapters.dtos.product;

import com.br.lfmelo.core.model.Product;
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

    public Product toEntity(){
        return new Product(id, category, name, price, description, active, createdAt, updatedAt);
    }

    public static ProductDTO fromProduct(Product product){
        return new ProductDTO(product.getId(), product.getCategory(), product.getName(), product.getPrice(), product.getDescription(), product.getActive(), product.getCreatedAt(), product.getUpdatedAt());
    }
}

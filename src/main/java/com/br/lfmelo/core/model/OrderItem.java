package com.br.lfmelo.core.model;

import com.br.lfmelo.adapters.dtos.order.OrderDTO;
import com.br.lfmelo.adapters.dtos.product.ProductDTO;

import java.math.BigDecimal;

public class OrderItem {

    private Long id;
    private OrderDTO order;
    private ProductDTO product;
    private Integer amount;
    private BigDecimal unitPrice;
    private String notes;

    public OrderItem(Long id, OrderDTO order, ProductDTO product, Integer amount, BigDecimal unitPrice, String notes) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

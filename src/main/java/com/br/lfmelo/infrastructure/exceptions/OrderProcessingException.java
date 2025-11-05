package com.br.lfmelo.infrastructure.exceptions;

public class OrderProcessingException extends RuntimeException {
    public OrderProcessingException(String message) {
        super(message);
    }
}

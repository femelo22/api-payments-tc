package com.br.lfmelo.infrastructure.exceptions;

public class UniqueViolationException extends RuntimeException {
    public UniqueViolationException(String message) {
        super(message);
    }
}

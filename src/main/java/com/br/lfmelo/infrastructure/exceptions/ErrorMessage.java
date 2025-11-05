package com.br.lfmelo.infrastructure.exceptions;

public record ErrorMessage(
        String path,
        int statusCode,
        String errorMessage
) {
}

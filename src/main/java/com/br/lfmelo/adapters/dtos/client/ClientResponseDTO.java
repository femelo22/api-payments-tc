package com.br.lfmelo.adapters.dtos.client;

import java.time.LocalDateTime;

public record ClientResponseDTO(
        Long id,
        String name,
        String cpf,
        String email,
        String phone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}


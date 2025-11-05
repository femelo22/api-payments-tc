package com.br.lfmelo.adapters.mappers;

import com.br.lfmelo.adapters.driven.entities.ClientEntity;
import com.br.lfmelo.adapters.dtos.client.ClientRequestDTO;
import com.br.lfmelo.adapters.dtos.client.ClientResponseDTO;
import com.br.lfmelo.core.model.Client;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-05T19:04:48-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client clientRequestDTOToClient(ClientRequestDTO clientRequestDTO) {
        if ( clientRequestDTO == null ) {
            return null;
        }

        String name = null;
        String cpf = null;
        String email = null;
        String phone = null;

        name = clientRequestDTO.name();
        cpf = clientRequestDTO.cpf();
        email = clientRequestDTO.email();
        phone = clientRequestDTO.phone();

        Long id = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        Client client = new Client( id, name, cpf, email, phone, createdAt, updatedAt );

        return client;
    }

    @Override
    public ClientResponseDTO clientToClientResponseDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String cpf = null;
        String email = null;
        String phone = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        email = client.getEmail();
        phone = client.getPhone();
        createdAt = client.getCreatedAt();
        updatedAt = client.getUpdatedAt();

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO( id, name, cpf, email, phone, createdAt, updatedAt );

        return clientResponseDTO;
    }

    @Override
    public ClientEntity clientToClientEntity(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId( client.getId() );
        clientEntity.setCpf( client.getCpf() );
        clientEntity.setName( client.getName() );
        clientEntity.setEmail( client.getEmail() );
        clientEntity.setPhone( client.getPhone() );
        clientEntity.setCreatedAt( client.getCreatedAt() );
        clientEntity.setUpdatedAt( client.getUpdatedAt() );

        return clientEntity;
    }

    @Override
    public Client clientEntityToClient(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String cpf = null;
        String email = null;
        String phone = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = clientEntity.getId();
        name = clientEntity.getName();
        cpf = clientEntity.getCpf();
        email = clientEntity.getEmail();
        phone = clientEntity.getPhone();
        createdAt = clientEntity.getCreatedAt();
        updatedAt = clientEntity.getUpdatedAt();

        Client client = new Client( id, name, cpf, email, phone, createdAt, updatedAt );

        return client;
    }
}

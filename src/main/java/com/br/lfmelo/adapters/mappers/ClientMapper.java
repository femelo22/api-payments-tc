package com.br.lfmelo.adapters.mappers;

import com.br.lfmelo.adapters.driven.entities.ClientEntity;
import com.br.lfmelo.adapters.dtos.client.ClientRequestDTO;
import com.br.lfmelo.adapters.dtos.client.ClientResponseDTO;
import com.br.lfmelo.core.model.Client;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client clientRequestDTOToClient(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO clientToClientResponseDTO(Client client);

    ClientEntity clientToClientEntity(Client client);

    Client clientEntityToClient(ClientEntity clientEntity);
}
package com.certant.boutique.api.mappers;

import com.certant.boutique.api.dto.ClientDto;
import com.certant.boutique.domain.models.Client;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientMapper {

    public static ClientDto clientToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setDni(client.getDni());
        clientDto.setName(client.getName());
        clientDto.setLastName(client.getLastName());
        clientDto.setServicesTaken(client.getServicesTaken());
        clientDto.setPremium(client.isPremium());
        return clientDto;
    }

    public static Client dtoToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setDni(clientDto.getDni());
        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());
        client.setServicesTaken(clientDto.getServicesTaken());
        client.setPremium(clientDto.isPremium());
        return client;
    }
}

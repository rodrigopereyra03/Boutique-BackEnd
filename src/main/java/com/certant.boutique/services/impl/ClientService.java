package com.certant.boutique.services.impl;

import com.certant.boutique.api.dto.ClientDto;
import com.certant.boutique.api.mappers.ClientMapper;
import com.certant.boutique.domain.models.Client;
import com.certant.boutique.repositories.IClientRepository;
import com.certant.boutique.services.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    private final IClientRepository iClientRepository;

    public ClientService(IClientRepository iClientRepository) {
        this.iClientRepository = iClientRepository;
    }

    @Override
    public List<ClientDto> getClients() {
        List<Client> clients = iClientRepository.findAll();

        return clients.stream()
                .map(ClientMapper::clientToClientDto)
                .toList();
    }

    @Override
    public ClientDto getClientByDni(int dni) {
        Optional<Client> client = Optional.ofNullable(iClientRepository.findByDni(dni));

        return ClientMapper.clientToClientDto(client.orElse(new Client()));
    }


    @Override
    public ClientDto createClient(ClientDto clientDto) {
        return ClientMapper.clientToClientDto(iClientRepository.save(ClientMapper.dtoToClient(clientDto)));
    }





}

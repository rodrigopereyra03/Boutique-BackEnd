package com.certant.boutique.services;

import com.certant.boutique.api.dto.ClientDto;

import java.util.List;

public interface IClientService {

    List<ClientDto> getClients();

    ClientDto getClientByDni(int dni);

    ClientDto createClient(ClientDto clientDto);





}

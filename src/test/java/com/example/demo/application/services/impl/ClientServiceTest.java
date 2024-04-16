package com.example.demo.application.services.impl;

import com.example.demo.api.dto.ClientDto;
import com.example.demo.domain.models.Client;
import com.example.demo.infraestructure.repositories.IClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    @Mock
    private IClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getClients() {
        Client client = new Client();
        client.setId(1L);
        client.setDni(44968552);

        Client client1 = new Client();
        client1.setId(2L);
        client1.setDni(44968152);

        List<Client> clientList = new ArrayList<>();

        clientList.add(client);
        clientList.add(client1);

        when(clientRepository.findAll()).thenReturn(clientList);

        ClientDto clientDto = new ClientDto();
        clientDto.setId(1L);
        clientDto.setDni(44968252);

        ClientDto clientDto1 = new ClientDto();
        clientDto1.setId(2L);
        clientDto1.setDni(44968551);

        List<ClientDto> result = clientService.getClients();

        verify(clientRepository,times(1)).findAll();

        assertEquals(2, result.size());
        assertEquals(clientDto.getId(), result.get(0).getId());
        assertEquals(clientDto1.getId(), result.get(1).getId());


    }

    @Test
    void getClientByDni() {
        Client clientEntity = new Client();
        clientEntity.setId(1L);
        clientEntity.setDni(12345678);
        clientEntity.setName("Juan");
        clientEntity.setLastName("Perez");

        when(clientRepository.findByDni(12345678)).thenReturn(clientEntity);

        ClientDto clientDto = new ClientDto();
        clientDto.setId(1L);
        clientDto.setDni(12345678);
        clientDto.setName("Juan");
        clientDto.setLastName("Perez");

        ClientDto result = clientService.getClientByDni(12345678);
        verify(clientRepository, times(1)).findByDni(12345678);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(12345678, result.getDni());
        assertEquals("Juan", result.getName());
        assertEquals("Perez", result.getLastName());
    }

    @Test
    public void testGetClientByDniNotFound() {
        when(clientRepository.findByDni(99999999)).thenReturn(new Client());
        ClientDto result = clientService.getClientByDni(99999999);

        verify(clientRepository, times(1)).findByDni(99999999);
        assertNull(result.getId());

    }

    @Test
    void createClient() {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(1L);
        clientDto.setDni(44968552);

        Client client = new Client();
        client.setId(1L);
        client.setDni(44968552);

        when(clientRepository.save(any(Client.class))).thenReturn(client);
        ClientDto result = clientService.createClient(clientDto);

        verify(clientRepository,times(1)).save(any(Client.class));
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(44968552,result.getDni());

    }
}
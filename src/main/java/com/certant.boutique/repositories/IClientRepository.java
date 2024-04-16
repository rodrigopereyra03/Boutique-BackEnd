package com.certant.boutique.repositories;

import com.certant.boutique.domain.models.Client;

import java.util.List;

public interface IClientRepository {

    List<Client> findAll();

    Client findByDni(int dni);

    Client findById(Long id);

    Client save(Client client);

    void deleteClient(Long id);

    boolean existsById(Long id);
}

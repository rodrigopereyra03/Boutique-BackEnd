package com.certant.boutique.repositories.sql;

import com.certant.boutique.domain.exceptions.ClientNotFoundException;
import com.certant.boutique.domain.models.Client;
import com.certant.boutique.repositories.IClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ClientSQLRepository implements IClientRepository {

    private final IClientSQLRepository sqlRepository;

    public ClientSQLRepository(IClientSQLRepository sqlRepository) {
        this.sqlRepository = sqlRepository;
    }

    @Override
    public List<Client> findAll() {
        return sqlRepository.findAll();
    }

    @Override
    public Client findByDni(int dni) {
        return sqlRepository.findByDni(dni);
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = sqlRepository.findById(id);
        if(client.isEmpty()){
            throw new ClientNotFoundException("Client not found with id: "+ id);
        }
        return client.get();
    }

    @Override
    public Client save(Client client) {
        return sqlRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        sqlRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return sqlRepository.existsById(id);
    }
}

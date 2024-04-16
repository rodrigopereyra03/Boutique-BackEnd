package com.certant.boutique.repositories.sql;

import com.certant.boutique.domain.exceptions.ServiceBoutiqueNotFounException;
import com.certant.boutique.domain.models.ServiceBoutique;
import com.certant.boutique.repositories.IServiceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ServiceSQLRepository implements IServiceRepository {

    private final IServiceSQLRepository sqlRepository;

    public ServiceSQLRepository(IServiceSQLRepository sqlRepository) {
        this.sqlRepository = sqlRepository;
    }

    @Override
    public List<ServiceBoutique> findAll() {
        return sqlRepository.findAll();
    }

    @Override
    public ServiceBoutique findById(Long id) {
        Optional<ServiceBoutique> serviceBoutique = sqlRepository.findById(id);

        if(serviceBoutique.isEmpty()){
            throw new ServiceBoutiqueNotFounException("Service not found with id: "+id);
        }
        return serviceBoutique.get();
    }

    @Override
    public ServiceBoutique save(ServiceBoutique serviceBoutique) {
        return sqlRepository.save(serviceBoutique);
    }

    @Override
    public void deleteById(Long id) {
        sqlRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return sqlRepository.existsById(id);
    }
}

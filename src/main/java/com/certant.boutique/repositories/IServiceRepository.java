package com.certant.boutique.repositories;

import com.certant.boutique.domain.models.ServiceBoutique;

import java.util.List;

public interface IServiceRepository {

    List<ServiceBoutique> findAll();

    ServiceBoutique findById(Long id);

    ServiceBoutique save(ServiceBoutique serviceBoutique);

    void deleteById(Long id);

    boolean existsById(Long id);
}

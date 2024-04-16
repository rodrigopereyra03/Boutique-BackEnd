package com.certant.boutique.repositories.sql;

import com.certant.boutique.domain.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientSQLRepository extends JpaRepository<Client,Long> {

    Client findByDni(int dni);
}

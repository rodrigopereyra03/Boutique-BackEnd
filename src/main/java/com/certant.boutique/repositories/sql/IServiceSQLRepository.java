package com.certant.boutique.repositories.sql;

import com.certant.boutique.domain.models.ServiceBoutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceSQLRepository extends JpaRepository<ServiceBoutique,Long> {
}

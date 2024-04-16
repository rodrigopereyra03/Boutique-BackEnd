package com.certant.boutique.repositories.sql;

import com.certant.boutique.domain.models.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IWorkOrderSQLRepository extends JpaRepository<WorkOrder,Long> {

    boolean existsByLocalDateTime(LocalDateTime localDateTime);
}

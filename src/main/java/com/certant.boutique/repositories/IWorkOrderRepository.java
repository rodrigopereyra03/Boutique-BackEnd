package com.certant.boutique.repositories;

import com.certant.boutique.domain.models.WorkOrder;

import java.time.LocalDateTime;
import java.util.List;

public interface IWorkOrderRepository {

    List<WorkOrder> findAll();

    WorkOrder findById(Long id);

    WorkOrder save(WorkOrder workOrder);

    void deleteOrder(Long id);

    boolean existsById(Long id);

    boolean existsByLocalDateTime(LocalDateTime localDateTime);

}

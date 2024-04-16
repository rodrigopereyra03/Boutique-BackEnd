package com.certant.boutique.repositories.sql;

import com.certant.boutique.domain.exceptions.WorkOrderNotFoundException;
import com.certant.boutique.domain.models.WorkOrder;
import com.certant.boutique.repositories.IWorkOrderRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkOrderSQLRepository implements IWorkOrderRepository {

    private final IWorkOrderSQLRepository repository;

    public WorkOrderSQLRepository(IWorkOrderSQLRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WorkOrder> findAll() {
        return repository.findAll();
    }

    @Override
    public WorkOrder findById(Long id) {
        Optional<WorkOrder> order = repository.findById(id);
        if(order.isEmpty()){
            throw new WorkOrderNotFoundException("Work Order not found with id: "+id);
        }
        return order.get();
    }

    @Override
    public WorkOrder save(WorkOrder workOrder) {
        return repository.save(workOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);

    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByLocalDateTime(LocalDateTime localDateTime) {
        return repository.existsByLocalDateTime(localDateTime);
    }
}

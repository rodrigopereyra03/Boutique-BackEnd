package com.certant.boutique.domain.models;

import com.certant.boutique.domain.enums.ServiceType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class ServiceBoutique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    private BigDecimal price;

    @ManyToMany
    private List<WorkOrder> workOrder;

    public ServiceBoutique(String name, ServiceType serviceType, BigDecimal price) {
        this.name = name;
        this.serviceType = serviceType;
        this.price = price;

    }

    public ServiceBoutique() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<WorkOrder> getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(List<WorkOrder> workOrder) {
        this.workOrder = workOrder;
    }
}

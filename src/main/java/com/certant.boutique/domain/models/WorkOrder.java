package com.certant.boutique.domain.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime localDateTime;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    private Car car;

    @ManyToMany
    @JoinTable(
            name = "wor_order_services",
            joinColumns = @JoinColumn(name = "work_order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<ServiceBoutique> serviceList;

    private BigDecimal totalPrice;


    public WorkOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<ServiceBoutique> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceBoutique> serviceList) {
        this.serviceList = serviceList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}

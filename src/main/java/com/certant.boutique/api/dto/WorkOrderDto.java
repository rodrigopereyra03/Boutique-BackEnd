package com.certant.boutique.api.dto;

import com.certant.boutique.domain.models.Car;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class WorkOrderDto {

    private Long id;

    private LocalDateTime localDateTime;

    private int clientDni;

    private Car car;

    private List<ServiceBoutiqueDto> serviceList;

    private BigDecimal totalPrice;

    public WorkOrderDto() {
    }

    public WorkOrderDto(LocalDateTime localDateTime, int clientDni, Car car, List<ServiceBoutiqueDto> serviceList) {
        this.localDateTime = localDateTime;
        this.clientDni = clientDni;
        this.car = car;
        this.serviceList = serviceList;
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

    public int getClientDni() {
        return clientDni;
    }

    public void setClientDni(int clientDni) {
        this.clientDni = clientDni;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<ServiceBoutiqueDto> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceBoutiqueDto> serviceList) {
        this.serviceList = serviceList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}

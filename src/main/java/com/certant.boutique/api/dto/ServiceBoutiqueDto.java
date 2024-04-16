package com.certant.boutique.api.dto;

import com.certant.boutique.domain.enums.ServiceType;

import java.math.BigDecimal;

public class ServiceBoutiqueDto {

    private Long id;

    private String name;

    private ServiceType serviceType;

    private String serviceDescription;

    private BigDecimal price;

    public ServiceBoutiqueDto(String name, ServiceType serviceType, BigDecimal price) {
        this.name = name;
        this.serviceType = serviceType;
        this.price = price;
    }

    public ServiceBoutiqueDto() {
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

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

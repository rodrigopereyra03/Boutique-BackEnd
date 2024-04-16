package com.certant.boutique.services;

import com.certant.boutique.api.dto.ServiceBoutiqueDto;

import java.util.List;

public interface IServiceBoutique {

    List<ServiceBoutiqueDto> getServices();

    ServiceBoutiqueDto getServicesById(Long id);

    ServiceBoutiqueDto createServices(ServiceBoutiqueDto servicesDto);

}

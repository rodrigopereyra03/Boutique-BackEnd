package com.certant.boutique.services.impl;

import com.certant.boutique.api.dto.ServiceBoutiqueDto;
import com.certant.boutique.api.mappers.ServiceBoutiqueMapper;
import com.certant.boutique.domain.models.ServiceBoutique;
import com.certant.boutique.repositories.IServiceRepository;
import com.certant.boutique.services.IServiceBoutique;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBoutiqueService implements IServiceBoutique {

    private final IServiceRepository repositoryService;


    public ServiceBoutiqueService(IServiceRepository repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Override
    public List<ServiceBoutiqueDto> getServices() {
        List<ServiceBoutique> services = repositoryService.findAll();
        return services.stream()
                .map(ServiceBoutiqueMapper::serviceToDto)
                .toList();
    }

    @Override
    public ServiceBoutiqueDto getServicesById(Long id) {
        return ServiceBoutiqueMapper.serviceToDto(repositoryService.findById(id));
    }

    @Override
    public ServiceBoutiqueDto createServices(ServiceBoutiqueDto servicesDto) {
        ServiceBoutique serviceBoutique = ServiceBoutiqueMapper.dtoToService(servicesDto);
        return ServiceBoutiqueMapper.serviceToDto( repositoryService.save(serviceBoutique));
    }


}

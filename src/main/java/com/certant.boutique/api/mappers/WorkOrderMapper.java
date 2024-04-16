package com.certant.boutique.api.mappers;

import com.certant.boutique.api.dto.ServiceBoutiqueDto;
import com.certant.boutique.api.dto.WorkOrderDto;
import com.certant.boutique.domain.exceptions.ClientNotFoundException;
import com.certant.boutique.domain.models.Client;
import com.certant.boutique.domain.models.ServiceBoutique;
import com.certant.boutique.domain.models.WorkOrder;
import com.certant.boutique.repositories.IClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class WorkOrderMapper {

    private final IClientRepository clientRepository;

    public WorkOrderMapper(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public WorkOrder dtoToOrder(WorkOrderDto dto) {
        WorkOrder order = new WorkOrder();
        order.setLocalDateTime(dto.getLocalDateTime());

        Client client = clientRepository.findByDni(dto.getClientDni());

        if(client == null){
            throw new ClientNotFoundException("Client not found with dni");
        }

        order.setClient(client);
        order.setCar(dto.getCar());


        // Mapear explícitamente la lista de servicios
        List<ServiceBoutique> serviceList = dto.getServiceList().stream()
                .map(serviceDto -> {
                    ServiceBoutique service = new ServiceBoutique();
                    service.setId(serviceDto.getId());
                    service.setName(serviceDto.getName());
                    service.setServiceType(serviceDto.getServiceType());
                    service.setPrice(serviceDto.getPrice());
                    return service;
                })
                .toList();

        order.setServiceList(serviceList);
        order.setTotalPrice(dto.getTotalPrice());
        return order;
    }

    public static WorkOrderDto orderToDto(WorkOrder order) {
        WorkOrderDto dto = new WorkOrderDto();
        dto.setId(order.getId());
        dto.setLocalDateTime(order.getLocalDateTime());
        dto.setClientDni(order.getClient().getDni());
        dto.setCar(order.getCar());

        // Mapear explícitamente la lista de servicios
        List<ServiceBoutiqueDto> serviceDtoList = order.getServiceList().stream()
                .map(service -> {
                    ServiceBoutiqueDto serviceDto = new ServiceBoutiqueDto();
                    serviceDto.setId(service.getId());
                    serviceDto.setName(service.getName());
                    serviceDto.setServiceType(service.getServiceType());
                    serviceDto.setServiceDescription(service.getServiceType().getDescription());
                    serviceDto.setPrice(service.getPrice());
                    return serviceDto;
                })
                .collect(Collectors.toList());

        dto.setServiceList(serviceDtoList);
        dto.setTotalPrice(order.getTotalPrice());
        return dto;
    }


    public List<ServiceBoutique> dtoListToServiceList(List<ServiceBoutiqueDto> dtoList) {
        return dtoList.stream()
                .map(this::dtoToService)
                .collect(Collectors.toList());
    }

    // Método para convertir un ServiceDto a un Service
    private ServiceBoutique dtoToService(ServiceBoutiqueDto dto) {
        ServiceBoutique service = new ServiceBoutique();
        service.setId(dto.getId());
        service.setName(dto.getName());
        service.setServiceType(dto.getServiceType());
        service.setPrice(dto.getPrice());
        return service;
    }

}

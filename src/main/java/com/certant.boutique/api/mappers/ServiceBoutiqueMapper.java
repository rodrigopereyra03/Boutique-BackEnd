package com.certant.boutique.api.mappers;

import com.certant.boutique.api.dto.ServiceBoutiqueDto;
import com.certant.boutique.domain.enums.ServiceType;
import com.certant.boutique.domain.models.ServiceBoutique;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceBoutiqueMapper {

    public static ServiceBoutique dtoToService(ServiceBoutiqueDto dto){
        ServiceBoutique service = new ServiceBoutique();
        service.setId(dto.getId());
        service.setName(dto.getName());
        service.setPrice(dto.getPrice());

        ServiceType serviceType = ServiceType.valueOf(dto.getServiceType().toString());
        service.setServiceType(serviceType);
        dto.setServiceDescription(serviceType.getDescription());

        return service;
    }

    public static ServiceBoutiqueDto serviceToDto(ServiceBoutique serviceBoutique){
        ServiceBoutiqueDto dto = new ServiceBoutiqueDto();
        dto.setId(serviceBoutique.getId());
        dto.setName(serviceBoutique.getName());
        dto.setPrice(serviceBoutique.getPrice());
        dto.setServiceType(serviceBoutique.getServiceType());
        dto.setServiceDescription(serviceBoutique.getServiceType().getDescription());


        return dto;
    }

    private static ServiceType mapServiceType(String serviceName) {
        return switch (serviceName) {
            case "ALINEACION Y BALANCEO" -> ServiceType.ALINEACION_BASICO;
            case "ALINEACION Y BALANCEO CON CAMBIO DE CUBIERTAS" -> ServiceType.ALINEACION_COMPLETO;
            case "BASICO" -> ServiceType.LAVADO_BASICO;
            case "COMPLETO" -> ServiceType.LAVADO_COMPLETO;
            case "PREMIUM" -> ServiceType.LAVADO_PREMIUM;
            case "BASICO ACEITE" -> ServiceType.ACEITE_BASICO;
            case "ALTO RENDIMIENTO, MOTORES DIESEL O NAFTEROS" -> ServiceType.ACEITE_COMPLETO;
            default -> throw new IllegalArgumentException("Tipo de servicio no válido: " + serviceName);
        };
    }

}

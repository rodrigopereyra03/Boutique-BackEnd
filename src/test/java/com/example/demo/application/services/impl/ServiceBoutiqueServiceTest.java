package com.example.demo.application.services.impl;


import com.example.demo.api.dto.ServiceBoutiqueDto;
import com.example.demo.domain.enums.ServiceType;
import com.example.demo.domain.models.ServiceBoutique;
import com.example.demo.infraestructure.repositories.IServiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ServiceBoutiqueServiceTest {

    @Mock
    private IServiceRepository servicesRepository;


    @InjectMocks
    private ServiceBoutiqueService servicesService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getServices() {
        // Crear datos de prueba
        ServiceBoutique service1 = new ServiceBoutique();
        service1.setId(1L);
        service1.setServiceType(ServiceType.LAVADO_BASICO);

        ServiceBoutique service2 = new ServiceBoutique();
        service2.setId(2L);
        service2.setServiceType(ServiceType.ACEITE_COMPLETO);

        List<ServiceBoutique> serviceList = new ArrayList<>();
        serviceList.add(service1);
        serviceList.add(service2);

        // Mockear el comportamiento del repositorio
        when(servicesRepository.findAll()).thenReturn(serviceList);

        // Mockear el comportamiento del mapper
        ServiceBoutiqueDto dto1 = new ServiceBoutiqueDto();
        dto1.setId(1L);
        dto1.setServiceType(ServiceType.LAVADO_BASICO);

        ServiceBoutiqueDto dto2 = new ServiceBoutiqueDto();
        dto2.setId(2L);
        dto2.setServiceType(ServiceType.ACEITE_COMPLETO);

        // Llamar al método que se está probando
        List<ServiceBoutiqueDto> result = servicesService.getServices();

        // Verificación de que se llamó al método findAll del repositorio
        verify(servicesRepository, times(1)).findAll();

        // Verificar el tamaño y los valores de la lista de DTOs resultante
        assertEquals(2, result.size());
        assertEquals(dto1.getId(), result.get(0).getId());
        assertEquals(dto2.getId(), result.get(1).getId());
    }

    @Test
    void getServicesById() {
        // Crear un objeto de prueba para el servicio
        ServiceBoutique serviceBoutique = new ServiceBoutique();
        serviceBoutique.setId(1L);
        serviceBoutique.setServiceType(ServiceType.ACEITE_COMPLETO);

        // Mockear el comportamiento del repositorio
        when(servicesRepository.findById(1L)).thenReturn(serviceBoutique);

        // Mockear el comportamiento del mapper
        ServiceBoutiqueDto serviceDto = new ServiceBoutiqueDto();
        serviceDto.setId(1L);
        serviceDto.setServiceType(ServiceType.ACEITE_COMPLETO);



        // Llamar al método que se está probando
        ServiceBoutiqueDto result = servicesService.getServicesById(1L);

        // Verificación de que se llamó al método findById del repositorio
        verify(servicesRepository, times(1)).findById(1L);

        // Verificar que el resultado sea el DTO esperado
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(ServiceType.ACEITE_COMPLETO, result.getServiceType());
    }

    @Test
    void createServices() {
        ServiceBoutiqueDto serviceDto = new ServiceBoutiqueDto();
        serviceDto.setId(1L);
        serviceDto.setServiceType(ServiceType.ACEITE_COMPLETO);

        // Mockear el comportamiento del mapper para convertir el DTO en una entidad
        ServiceBoutique serviceEntity = new ServiceBoutique();
        serviceEntity.setId(1L);
        serviceEntity.setServiceType(ServiceType.ACEITE_COMPLETO);


        // Mockear el comportamiento del repositorio para guardar la entidad y devolverla
        when(servicesRepository.save(any(ServiceBoutique.class))).thenReturn(serviceEntity);

        // Llamar al método que se está probando
        ServiceBoutiqueDto result = servicesService.createServices(serviceDto);

        // Verificar que se llamó al método save del repositorio
        verify(servicesRepository, times(1)).save(any(ServiceBoutique.class));


        // Verificar el resultado sea el DTO esperado
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(ServiceType.ACEITE_COMPLETO, result.getServiceType());
    }

    @Test
    void updateServices() {
    }

    @Test
    void deleteServices() {
    }
}
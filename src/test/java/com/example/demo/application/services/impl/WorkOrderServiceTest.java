package com.example.demo.application.services.impl;

import com.example.demo.api.dto.CarDto;
import com.example.demo.api.dto.ServiceBoutiqueDto;
import com.example.demo.api.dto.WorkOrderDto;
import com.example.demo.api.mappers.WorkOrderMapper;
import com.example.demo.domain.enums.ServiceType;
import com.example.demo.domain.models.Car;
import com.example.demo.domain.models.Client;
import com.example.demo.domain.models.ServiceBoutique;
import com.example.demo.domain.models.WorkOrder;
import com.example.demo.infraestructure.repositories.IClientRepository;
import com.example.demo.infraestructure.repositories.IWorkOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WorkOrderServiceTest {

    @Mock
    private IWorkOrderRepository workOrderRepository;
    @Mock
    private IClientRepository clientRepository;

    @Mock
    private WorkOrderMapper mapper;

    @InjectMocks
    private WorkOrderService workOrderService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getWorkOrders() {
        ServiceBoutique service1 = new ServiceBoutique();
        service1.setId(1L);
        service1.setServiceType(ServiceType.LAVADO_BASICO);

        ServiceBoutique service2 = new ServiceBoutique();
        service2.setId(2L);
        service2.setServiceType(ServiceType.ACEITE_COMPLETO);

        List<ServiceBoutique> serviceList = new ArrayList<>();
        serviceList.add(service1);
        serviceList.add(service2);

        Car car = new Car();
        car.setId(1L);
        car.setPatent("AAA111");

        WorkOrder workOrder = new WorkOrder();
        workOrder.setId(1L);
        workOrder.setClient(new Client(44968552));
        workOrder.setTotalPrice(new BigDecimal(500));
        workOrder.setServiceList(serviceList);
        workOrder.setCar(car);
        workOrder.setLocalDateTime(LocalDateTime.now());

        when(workOrderRepository.findAll()).thenReturn(List.of(workOrder));

        WorkOrderDto workOrderDto = WorkOrderMapper.orderToDto(workOrder);

        List<WorkOrderDto> workOrderDtoList = workOrderService.getWorkOrders();

        verify(workOrderRepository,times(1)).findAll();

        assertEquals(1, workOrderDtoList.size());
        assertEquals(workOrderDto.getId(), workOrderDtoList.get(0).getId());

    }

    @Test
    void getOrderById() {
        ServiceBoutique service1 = new ServiceBoutique();
        service1.setId(1L);
        service1.setServiceType(ServiceType.LAVADO_BASICO);

        ServiceBoutique service2 = new ServiceBoutique();
        service2.setId(2L);
        service2.setServiceType(ServiceType.ACEITE_COMPLETO);

        List<ServiceBoutique> serviceList = new ArrayList<>();
        serviceList.add(service1);
        serviceList.add(service2);

        Car car = new Car();
        car.setId(1L);
        car.setPatent("AAA111");

        WorkOrder workOrder = new WorkOrder();
        workOrder.setId(1L);
        workOrder.setClient(new Client(44968552));
        workOrder.setTotalPrice(new BigDecimal(500));
        workOrder.setServiceList(serviceList);
        workOrder.setCar(car);
        workOrder.setLocalDateTime(LocalDateTime.now());

        when(workOrderRepository.findById(1L)).thenReturn(workOrder);

        WorkOrderDto workOrderDto = WorkOrderMapper.orderToDto(workOrder);

        WorkOrderDto result = workOrderService.getOrderById(1L);

        verify(workOrderRepository,times(1)).findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void createOrder() {

        Client existingClient = new Client(12345678);
        existingClient.setId(1L);
        existingClient.setServicesTaken(5);
        when(clientRepository.findByDni(12345678)).thenReturn(existingClient);


        List<ServiceBoutique> serviceList = new ArrayList<>();

        BigDecimal totalPrice = new BigDecimal("100");
        when(mapper.dtoListToServiceList(any())).thenReturn(serviceList);


        Car car = new Car();
        car.setPatent("AAA111");


        WorkOrder order = new WorkOrder();
        order.setId(1L);
        order.setCar(car);
        order.setClient(existingClient);
        order.setServiceList(serviceList);
        order.setTotalPrice(new BigDecimal(100));





        WorkOrderDto dto = new WorkOrderDto(LocalDateTime.now(),existingClient.getDni(), car,new ArrayList<>());
        when(mapper.dtoToOrder(dto)).thenReturn(order);
        when(workOrderRepository.save(any(WorkOrder.class))).thenReturn(order);
        WorkOrderDto result = workOrderService.createOrder(dto);


        verify(clientRepository, times(1)).findByDni(12345678);
        verify(workOrderRepository, times(1)).save(any(WorkOrder.class));


        assertNotNull(result);
        assertEquals(existingClient.getId(), result.getId());
        assertEquals(totalPrice, result.getTotalPrice());
        assertEquals("AAA111", result.getCar().getPatent());
        }


    @Test
    void deleteOrder() {
        Long orderIdToDelete = 1L;

        when(workOrderRepository.existsById(orderIdToDelete)).thenReturn(true);

        String result = workOrderService.deleteOrder(orderIdToDelete);

        verify(workOrderRepository, times(1)).existsById(orderIdToDelete);

        verify(workOrderRepository, times(1)).deleteOrder(orderIdToDelete);

        assertEquals("The Order has been successfully deleted", result);
    }

    @Test
    public void testDeleteOrder_OrderNotFound() {
        Long orderIdToDelete = 2L;

        when(workOrderRepository.existsById(orderIdToDelete)).thenReturn(false);

        String result = workOrderService.deleteOrder(orderIdToDelete);

        verify(workOrderRepository, times(1)).existsById(orderIdToDelete);

        verify(workOrderRepository, never()).deleteOrder(orderIdToDelete);

        assertEquals("The Order not found with id: 2", result);
    }
}
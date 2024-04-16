package com.certant.boutique.services.impl;

import com.certant.boutique.api.dto.WorkOrderDto;
import com.certant.boutique.api.mappers.WorkOrderMapper;
import com.certant.boutique.domain.exceptions.CarNotFoundException;
import com.certant.boutique.domain.exceptions.WorkOrderNotFoundException;
import com.certant.boutique.domain.models.Client;
import com.certant.boutique.domain.models.ServiceBoutique;
import com.certant.boutique.domain.models.WorkOrder;
import com.certant.boutique.repositories.IClientRepository;
import com.certant.boutique.repositories.IWorkOrderRepository;
import com.certant.boutique.services.IWorkOrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkOrderService implements IWorkOrderService {

    private final IWorkOrderRepository repository;
    private final IClientRepository clientRepository;
    private final WorkOrderMapper mapper;

    public WorkOrderService(IWorkOrderRepository repository, IClientRepository clientRepository, WorkOrderMapper mapper) {
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Override
    public List<WorkOrderDto> getWorkOrders() {
        List<WorkOrder> orders = repository.findAll();
        return orders.stream()
                .map(WorkOrderMapper::orderToDto)
                .toList();
    }

    @Override
    public WorkOrderDto getOrderById(Long id) {
        return WorkOrderMapper.orderToDto(repository.findById(id));
    }

    @Override
    public WorkOrderDto createOrder(WorkOrderDto dto) {
        Client client = clientRepository.findByDni(dto.getClientDni());
        if(client==null){
            client = new Client(dto.getClientDni());
        }

        client.setServicesTaken(client.getServicesTaken()+1);
        if(client.getServicesTaken()>5){
            client.setPremium(true);
        }

        clientRepository.save(client);

        List<ServiceBoutique> serviceList = mapper.dtoListToServiceList(dto.getServiceList());

        BigDecimal totalPrice = calculateTotalServices(serviceList);
        dto.setTotalPrice(totalPrice);

        String patent = dto.getCar().getPatent();

        if(!validatePatent(patent)){
            throw new CarNotFoundException("Invalid Format!!");
        }

        LocalDateTime dateTime = dto.getLocalDateTime();
        if(isLocalTimeReservation(dateTime)){
            throw new WorkOrderNotFoundException("Appointment already reserved");
        }

        WorkOrder workOrder = mapper.dtoToOrder(dto);
        workOrder.setClient(client);
        return WorkOrderMapper.orderToDto(repository.save(workOrder));
    }

    @Override
    public String deleteOrder(Long id) {
        if(repository.existsById(id)){
            repository.deleteOrder(id);
            return "The Order has been successfully deleted";
        }else {
            return "The Order not found with id: " + id;
        }
    }

    private BigDecimal calculateTotalServices(List<ServiceBoutique> serviceList) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (ServiceBoutique service : serviceList) {
            totalPrice = totalPrice.add(service.getPrice());
        }
        return totalPrice;
    }

    private boolean validatePatent(String patent) {
        // Expresión regular para el formato 'AAA111' o 'AA111AA'
        String format = "^(?:[A-Z]{3}\\d{3}|[A-Z]{2}\\d{3}[A-Z]{2})$";
        return patent.matches(format);
    }

    private boolean isLocalTimeReservation(LocalDateTime localDateTime){
        return repository.existsByLocalDateTime(localDateTime);
    }

}

package com.certant.boutique.services;

import com.certant.boutique.api.dto.WorkOrderDto;

import java.util.List;

public interface IWorkOrderService {

    List<WorkOrderDto> getWorkOrders();

    WorkOrderDto getOrderById(Long id);

    WorkOrderDto createOrder(WorkOrderDto dto);

    String deleteOrder(Long id);
}

package com.certant.boutique.api.controller;

import com.certant.boutique.api.dto.WorkOrderDto;
import com.certant.boutique.services.IWorkOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class WorkOrderController {

    private final IWorkOrderService service;

    public WorkOrderController(IWorkOrderService service) {
        this.service = service;
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<WorkOrderDto>> getOrders(){
        List<WorkOrderDto> workOrderDtoList = service.getWorkOrders();
        return ResponseEntity.status(HttpStatus.OK).body(workOrderDtoList);
    }


    @PostMapping(value = "/orders")
    public ResponseEntity<WorkOrderDto> createOrder(@RequestBody WorkOrderDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrder(dto));
    }


    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        String result = service.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping(value = "/order/{id}")
    public ResponseEntity<WorkOrderDto> getOrderById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getOrderById(id));
    }
}

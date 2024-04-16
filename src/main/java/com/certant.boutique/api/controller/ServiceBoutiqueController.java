package com.certant.boutique.api.controller;

import com.certant.boutique.api.dto.ServiceBoutiqueDto;
import com.certant.boutique.services.IServiceBoutique;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ServiceBoutiqueController {

    private final IServiceBoutique serviceBoutiqueService;

    public ServiceBoutiqueController(IServiceBoutique serviceBoutiqueService) {
        this.serviceBoutiqueService = serviceBoutiqueService;
    }

    //Metodos HTTP

    //Metodo GET
    @GetMapping(value = "/services")
    public ResponseEntity<List<ServiceBoutiqueDto>> getServices(){
        List<ServiceBoutiqueDto> servicesDtoList = serviceBoutiqueService.getServices();
        return ResponseEntity.status(HttpStatus.OK).body(servicesDtoList);
    }

    @GetMapping(value = "/service/{id}")
    public ResponseEntity<ServiceBoutiqueDto> getServiceById(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.OK).body(serviceBoutiqueService.getServicesById(id));
    }

    //POST
    @PostMapping(value = "/services")
    public ResponseEntity<ServiceBoutiqueDto> createService(@RequestBody ServiceBoutiqueDto dto){
        //Redirije hacia el responsable de crear una lampara
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceBoutiqueService.createServices(dto));
    }




}

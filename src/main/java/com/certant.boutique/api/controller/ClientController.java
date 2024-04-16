package com.certant.boutique.api.controller;

import com.certant.boutique.api.dto.ClientDto;
import com.certant.boutique.services.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientDto>> getClients(){
        List<ClientDto> clientDtoList = clientService.getClients();
        return ResponseEntity.status(HttpStatus.OK).body(clientDtoList);
    }

    @GetMapping(value = "/client/{dni}")
    public ResponseEntity<ClientDto> getClientByDni(@PathVariable int dni){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientByDni(dni));
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(dto));
    }



}

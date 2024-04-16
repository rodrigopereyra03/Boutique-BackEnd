package com.certant.boutique.api.controller;

import com.certant.boutique.api.dto.CarDto;
import com.certant.boutique.services.ICarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    private final ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public ResponseEntity<List<CarDto>> getCars(){
        List<CarDto> carDtos = carService.getCars();
        return ResponseEntity.status(HttpStatus.OK).body(carDtos);
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(dto));
    }

    @GetMapping(value = "/cars/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(carService.getCarById(id));
    }
}

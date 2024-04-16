package com.example.demo.application.services.impl;


import com.example.demo.api.dto.CarDto;
import com.example.demo.domain.models.Car;
import com.example.demo.infraestructure.repositories.ICarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {

    @Mock
    private ICarRepository carRepository;


    @InjectMocks
    private CarService carService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCars() {
        Car car = new Car();
        car.setId(1L);
        car.setPatent("AAA111");

        Car car1 = new Car();
        car1.setId(2L);
        car1.setPatent("AA111AA");

        List<Car> carList = new ArrayList<>();
        carList.add(car);
        carList.add(car1);

        // Mockear el comportamiento del repositorio
        when(carRepository.findAll()).thenReturn(carList);

        // Mockear el comportamiento del mapper
        CarDto dto1 = new CarDto();
        dto1.setId(1L);
        dto1.setPatent("AAA111");

        CarDto dto2 = new CarDto();
        dto2.setId(2L);
        dto2.setPatent("AA111AA");

        // Llamar al método que se está probando
        List<CarDto> result = carService.getCars();

        // Verificación de que se llamó al método findAll del repositorio
        verify(carRepository, times(1)).findAll();

        // Verificar el tamaño y los valores de la lista de DTOs resultante
        assertEquals(2, result.size());
        assertEquals(dto1.getId(), result.get(0).getId());
        assertEquals(dto2.getId(), result.get(1).getId());
    }

    @Test
    void getCarById() {
        Car car = new Car();
        car.setId(1L);
        car.setPatent("AAA111");

        when(carRepository.findById(1L)).thenReturn(car);

        CarDto dto1 = new CarDto();
        dto1.setId(1L);
        dto1.setPatent("AAA111");

        CarDto result = carService.getCarById(1L);
        verify(carRepository, times(1)).findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(car.getPatent(),result.getPatent());
    }

    @Test
    void createCar() {
        CarDto dto1 = new CarDto();
        dto1.setId(1L);
        dto1.setPatent("AAA111");

        Car car = new Car();
        car.setId(1L);
        car.setPatent("AAA111");

        when(carRepository.save(any(Car.class))).thenReturn(car);

        CarDto result = carService.createCar(dto1);

        verify(carRepository,times(1)).save(any(Car.class));

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(car.getPatent(),result.getPatent());
    }
}
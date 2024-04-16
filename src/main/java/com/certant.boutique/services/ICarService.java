package com.certant.boutique.services;

import com.certant.boutique.api.dto.CarDto;

import java.util.List;

public interface ICarService {

    List<CarDto> getCars();

    CarDto getCarById(Long id);

    CarDto createCar(CarDto dto);
}

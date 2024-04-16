package com.certant.boutique.services.impl;

import com.certant.boutique.api.dto.CarDto;
import com.certant.boutique.api.mappers.CarMapper;
import com.certant.boutique.domain.models.Car;
import com.certant.boutique.repositories.ICarRepository;
import com.certant.boutique.services.ICarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {

    private final ICarRepository carRepository;

    public CarService(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<CarDto> getCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(CarMapper::carToDto)
                .toList();
    }

    @Override
    public CarDto getCarById(Long id) {
        return CarMapper.carToDto(carRepository.findById(id));
    }

    @Override
    public CarDto createCar(CarDto dto) {
        return CarMapper.carToDto(carRepository.save(CarMapper.dtoToCar(dto)));
    }
}

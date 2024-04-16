package com.certant.boutique.api.mappers;

import com.certant.boutique.api.dto.CarDto;
import com.certant.boutique.domain.models.Car;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CarMapper {

    public static Car dtoToCar(CarDto dto) {
        Car car = new Car();
        car.setId(dto.getId());
        car.setPatent(dto.getPatent());
        return car;
    }

    public static CarDto carToDto(Car car) {
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setPatent(car.getPatent());
        return dto;
    }

}

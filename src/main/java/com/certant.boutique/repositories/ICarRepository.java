package com.certant.boutique.repositories;

import com.certant.boutique.domain.models.Car;

import java.util.List;

public interface ICarRepository {

    List<Car> findAll();

    Car findById(Long id);

    Car save(Car car);
}

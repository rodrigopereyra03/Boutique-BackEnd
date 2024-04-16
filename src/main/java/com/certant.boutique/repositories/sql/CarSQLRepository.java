package com.certant.boutique.repositories.sql;

import com.certant.boutique.domain.exceptions.CarNotFoundException;
import com.certant.boutique.domain.models.Car;
import com.certant.boutique.repositories.ICarRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarSQLRepository implements ICarRepository {

    private final ICarSQLRepository repository;

    public CarSQLRepository(ICarSQLRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public Car findById(Long id) {
        Optional<Car> car = repository.findById(id);
        if(car.isEmpty()){
            throw new CarNotFoundException("Car not found with id: "+ id);
        }
        return car.get();
    }

    @Override
    public Car save(Car car) {
        return repository.save(car);
    }
}

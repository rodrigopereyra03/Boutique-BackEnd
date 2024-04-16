package com.certant.boutique.repositories.sql;

import com.certant.boutique.domain.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarSQLRepository extends JpaRepository<Car,Long> {
}

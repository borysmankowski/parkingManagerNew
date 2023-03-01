package com.masters.coding.car;

import com.masters.coding.car.model.Car;
import com.masters.coding.common.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByFuelType(FuelType fuelType);
}

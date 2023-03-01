package com.masters.coding.car;

import com.masters.coding.car.model.Car;
import com.masters.coding.common.FuelType;
import com.masters.coding.garage.GarageRepository;
import com.masters.coding.garage.model.Garage;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final GarageRepository garageRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public void createCar(Car car, int garageId) {
        Garage garage = garageRepository.findById(garageId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
                        .format("Teacher with id: {0} was not found", garageId)));

        car.setGarage(garage);
        carRepository.save(car);

    }

    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getCarsByFuelType(FuelType fuelType) {
        return carRepository.findByFuelType(fuelType);
    }

    public void deleteCarById(Integer id) {
        carRepository.deleteById(id);
    }
}

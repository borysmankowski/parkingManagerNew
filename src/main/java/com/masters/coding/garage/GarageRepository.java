package com.masters.coding.garage;

import com.masters.coding.garage.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GarageRepository extends JpaRepository<Garage, Integer> {
    List<Garage> findAllByActiveTrue();

}

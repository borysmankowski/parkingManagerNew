package com.masters.coding.car.model;

import com.masters.coding.common.FuelType;
import com.masters.coding.garage.model.Garage;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String model;
        @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @ManyToOne
    private Garage garage;

}

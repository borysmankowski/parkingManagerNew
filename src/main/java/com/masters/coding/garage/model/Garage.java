package com.masters.coding.garage.model;


import com.masters.coding.car.model.Car;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private int capacity;
    private boolean acceptsLpg;

    @OneToMany(mappedBy = "garage")
    private Set<Car> cars;
    private boolean active;

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", acceptsLpg=" + acceptsLpg +
                ", cars=" + cars +
                ", active=" + active +
                '}';
    }
}

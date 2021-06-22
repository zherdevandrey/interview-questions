package com.example.vivid.repository;

import com.example.vivid.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class CarRepository {

    private Map<Car, Integer> carsDb = new HashMap<>();


    public void addCar(Car car) {
        carsDb.put(car, 1);
    }

    public void removeCar(Car car)  {
        carsDb.remove(car);
    }

    public Set<Car> getAllCars(){
        return carsDb.keySet();
    }


}

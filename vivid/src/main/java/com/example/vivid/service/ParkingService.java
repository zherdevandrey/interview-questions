package com.example.vivid.service;

import com.example.vivid.domain.Car;

public interface ParkingService {


    void addCar(Car car);

    void removeCar(Car car);

    int getCarNum();


}

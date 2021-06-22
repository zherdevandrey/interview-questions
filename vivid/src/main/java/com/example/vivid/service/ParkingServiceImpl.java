package com.example.vivid.service;

import com.example.vivid.domain.Car;
import com.example.vivid.domain.CarEntry;
import com.example.vivid.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private CarRepository carRepository;
    private CarEntryService carEntryService;

    @Override
    public void addCar(Car car) {

        carEntryService.addCarEntry(car);

        carRepository.addCar(car);
    }

    @Override
    public void removeCar(Car car) {
        carRepository.removeCar(car);
    }

    @Override
    public int getCarNum() {
        return carRepository.getAllCars().size();
    }


}

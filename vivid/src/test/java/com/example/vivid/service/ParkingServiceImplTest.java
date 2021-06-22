package com.example.vivid.service;

import com.example.vivid.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParkingServiceImplTest {

    @Autowired
    private ParkingService parkingService;

    Car car = Car
            .builder()
            .gosNum("Т001СХ150")
            .build();



    @Test
    void addCar() {
        parkingService.addCar(car);
        int carNum = parkingService.getCarNum();
        assertThat(carNum).isEqualTo(1);

    }

    @Test
    void removeCar() {
    }

    @Test
    void getCarNum() {
    }
}
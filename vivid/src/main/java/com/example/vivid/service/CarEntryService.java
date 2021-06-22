package com.example.vivid.service;

import com.example.vivid.domain.Car;
import com.example.vivid.domain.CarEntry;

import java.time.LocalDate;

public interface CarEntryService {

    int countCars(LocalDate date);

    void addCarEntry(Car car);

}

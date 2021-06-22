package com.example.vivid.service;

import com.example.vivid.domain.Car;
import com.example.vivid.domain.CarEntry;
import com.example.vivid.repository.CarEntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CarEntryServiceImpl implements CarEntryService {

    private CarEntryRepository countingRepository;

    @Override
    public int countCars(LocalDate date) {
        List<CarEntry> carEntries = countingRepository.getCarEntries(date);
        return carEntries.size();
    }

    @Override
    public void addCarEntry(Car car) {
        countingRepository.addCarEntry(new CarEntry(car, LocalDate.now()));
    }

}

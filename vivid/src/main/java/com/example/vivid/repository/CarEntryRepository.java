package com.example.vivid.repository;

import com.example.vivid.domain.CarEntry;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CarEntryRepository {

    private List<CarEntry> carEntries = new ArrayList<>();

    public List<CarEntry> getCarEntries(LocalDate date) {

        return carEntries.stream()
                .filter(carEntry -> carEntry.getEntryDate().isEqual(date))
                .collect(Collectors.toList());

    }

    public void addCarEntry(CarEntry carEntry) {
        carEntries.add(carEntry);
    }
}

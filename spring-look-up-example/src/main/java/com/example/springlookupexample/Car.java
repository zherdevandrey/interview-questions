package com.example.springlookupexample;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Lookup
    public Passenger createPassenger() {
        return null;
    };

    public String drive(String name) {
        Passenger passenger = createPassenger();
        System.out.println(passenger);
        passenger.setName(name);
        return "car with " + passenger.getName();
    }
}
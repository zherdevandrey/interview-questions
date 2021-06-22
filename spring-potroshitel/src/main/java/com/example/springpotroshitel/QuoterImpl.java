package com.example.springpotroshitel;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class QuoterImpl implements Quoter {

    @RandomIntInjector(min = 1, max = 5)
    private int number;

    @Override
    public void sayQuote() {
        for (int i = 0; i < number; i++) {
            System.out.println("HELLO WORLD");
        }
    }

    public QuoterImpl() {
        System.out.println("PHASE 1");
    }

    public QuoterImpl(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

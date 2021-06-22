package com.example.springlookupexample;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class SpringLookUpExampleApplication implements CommandLineRunner {

    private Car car;

    public static void main(String[] args) {
        SpringApplication.run(SpringLookUpExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        car.drive("car 1");
        car.drive("car 2");
    }
}

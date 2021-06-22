package com.example.springpotroshitel;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringPotroshitelApplication {

    private Quoter quoter;

    public static void main(String[] args) {
        SpringApplication.run(SpringPotroshitelApplication.class, args);
    }


    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent refreshedEvent) {
        System.out.println("PHASE 4");
    }


}

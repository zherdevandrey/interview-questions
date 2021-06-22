package com.example.iron.starter;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent refreshedEvent) {
        System.out.println("ОТПРАВЛЯЕМ ВОРОНА");
    }
}

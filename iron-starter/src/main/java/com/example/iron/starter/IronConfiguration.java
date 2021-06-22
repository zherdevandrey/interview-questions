package com.example.iron.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IronConfiguration {

    @Bean
    @ConditionOnProduction
    public RavenListener ravenListener(){
        return new RavenListener();
    }

}

package com.gyanesh.foundations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FoundationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoundationsApplication.class, args);
    }
}

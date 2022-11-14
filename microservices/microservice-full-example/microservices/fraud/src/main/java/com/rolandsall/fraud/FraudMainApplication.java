package com.rolandsall.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FraudMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudMainApplication.class, args);
    }
}

package com.rolandsall.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
        scanBasePackages = {
                "com.rolandsall.customer",
                "com.rolandsall.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.rolandsall.client"
)
public class CustomerMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerMainApplication.class, args);
    }
}

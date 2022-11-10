package com.rolandsall.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryMainApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(DiscoveryMainApplication.class, args);
    }
}

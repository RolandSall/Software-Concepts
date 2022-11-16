package com.rolandsall.notification;

import com.rolandsall.amqp.RabbitMQMessageProducer;
import com.rolandsall.notification.configurations.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (
        scanBasePackages = {
                "com.rolandsall.notification",
                "com.rolandsall.amqp",
        }
)
@EnableEurekaClient
public class NotificationMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationMainApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner (RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
//        return args -> {
//            producer.publish("foo", notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }

}

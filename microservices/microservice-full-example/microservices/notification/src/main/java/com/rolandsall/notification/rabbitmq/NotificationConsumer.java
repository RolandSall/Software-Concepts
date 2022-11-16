package com.rolandsall.notification.rabbitmq;

import com.rolandsall.client.notification.NotificationRequest;
import com.rolandsall.notification.models.Notification;
import com.rolandsall.notification.services.INotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationConsumer {

    private final INotificationService notificationService;

    @Autowired
    public NotificationConsumer(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest request){
        log.info("Consumed {} from queue", request);
        notificationService.send(buildNotificationFromRequest(request));
    }

    private Notification buildNotificationFromRequest(NotificationRequest request) {
        return Notification.builder()
                .toCustomerEmail(request.toCustomerEmail)
                .toCustomerId(request.toCustomerId)
                .message(request.getMessage())
                .build();
    }
}

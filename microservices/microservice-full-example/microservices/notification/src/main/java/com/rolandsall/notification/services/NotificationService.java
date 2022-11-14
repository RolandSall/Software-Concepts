package com.rolandsall.notification.services;

import com.rolandsall.notification.models.Notification;
import com.rolandsall.notification.repositories.INotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class NotificationService implements INotificationService{


    private final INotificationRepository iNotificationRepository;

    public NotificationService(INotificationRepository iNotificationRepository) {
        this.iNotificationRepository = iNotificationRepository;
    }

    @Override
    public void send(Notification notification) {
        Notification notificationToBeSaved = Notification.builder()
                .toCustomerId(notification.getToCustomerId())
                .toCustomerEmail(notification.getToCustomerEmail())
                .message(notification.getMessage())
                .notificationId(UUID.randomUUID())
                .sender("Roland Salloum")
                .sentAt(LocalDateTime.now())
                .build();

        iNotificationRepository.save(notificationToBeSaved);
    }
}

package com.rolandsall.notification.services;

import com.rolandsall.notification.models.Notification;

public interface INotificationService {
    void send(Notification notification);
}

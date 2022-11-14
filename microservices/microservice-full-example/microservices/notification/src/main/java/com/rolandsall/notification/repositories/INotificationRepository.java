package com.rolandsall.notification.repositories;

import com.rolandsall.notification.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface INotificationRepository extends JpaRepository<Notification, UUID> {
}

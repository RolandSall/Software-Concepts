package com.rolandsall.notification.api;

import com.rolandsall.client.notification.NotificationRequest;
import com.rolandsall.notification.models.Notification;
import com.rolandsall.notification.services.INotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {

    private final INotificationService notificationService;

    @Autowired
    public NotificationController(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity sendNotification(@RequestBody NotificationRequest request) {
        log.info("New notification... {}", request);
        try {
            notificationService.send(buildNotificationFromRequest(request));
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    private Notification buildNotificationFromRequest(NotificationRequest request) {
        return Notification.builder()
                .toCustomerEmail(request.toCustomerEmail)
                .toCustomerId(request.toCustomerId)
                .message(request.getMessage())
                .build();
    }
}

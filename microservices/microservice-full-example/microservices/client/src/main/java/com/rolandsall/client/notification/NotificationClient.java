package com.rolandsall.client.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification", path = "api/v1/notification")
public interface NotificationClient {

    @PostMapping
    ResponseEntity sendNotification(@RequestBody NotificationRequest request);
}

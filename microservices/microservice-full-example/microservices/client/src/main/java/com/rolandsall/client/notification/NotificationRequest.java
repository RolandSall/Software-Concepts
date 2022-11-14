package com.rolandsall.client.notification;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NotificationRequest {
    public UUID toCustomerId;
    public String toCustomerEmail;
    public String message;
}

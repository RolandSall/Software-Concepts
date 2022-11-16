package com.rolandsall.client.notification;

import lombok.*;

import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class NotificationRequest {
    public UUID toCustomerId;
    public String toCustomerEmail;
    public String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationRequest request = (NotificationRequest) o;
        return Objects.equals(toCustomerId, request.toCustomerId) && Objects.equals(toCustomerEmail, request.toCustomerEmail) && Objects.equals(message, request.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toCustomerId, toCustomerEmail, message);
    }
}

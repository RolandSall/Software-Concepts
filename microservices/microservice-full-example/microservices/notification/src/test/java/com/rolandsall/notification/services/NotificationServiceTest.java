package com.rolandsall.notification.services;

import com.rolandsall.notification.models.Notification;
import com.rolandsall.notification.repositories.INotificationRepository;
import org.aspectj.weaver.ast.Not;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    @Mock
    private INotificationRepository iNotificationRepository;

    private INotificationService notificationService;

    @BeforeEach
    void setUp() {
        notificationService = new NotificationService(iNotificationRepository);
    }


    @Test
    void send_method_calls_dao_with_correct_parameters() {
        // arrange
        Notification notification = Notification
                .builder()
                .toCustomerEmail("roland.salloum00@outlook.com")
                .sender("Roland Salloum")
                .message("message")
                .build();

        // action
        notificationService.send(notification);

        // assert
        ArgumentCaptor<Notification> notificationArgumentCaptor = ArgumentCaptor.forClass(Notification.class);
        verify(iNotificationRepository).save(notificationArgumentCaptor.capture());
        Notification captorValue = notificationArgumentCaptor.getValue();

        assertThat(captorValue.getMessage()).isEqualTo(notification.getMessage());
        assertThat(captorValue.getSender()).isEqualTo(notification.getSender());
        assertThat(captorValue.getToCustomerEmail()).isEqualTo(notification.getToCustomerEmail());

    }

}
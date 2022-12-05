package com.rolandsall.order.service.domain.ports.input.message.listener.payment;

import com.rolandsall.order.service.domain.dto.message.PaymentResponse;

public interface IPaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}

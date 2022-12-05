package com.rolandsall.order.service.domain.payment;

import com.rolandsall.order.service.domain.dto.message.PaymentResponse;
import com.rolandsall.order.service.domain.ports.input.message.listener.payment.IPaymentResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PaymentResponseMessageListener implements IPaymentResponseMessageListener {
    @Override
    public void paymentCompleted(PaymentResponse paymentResponse) {

    }

    @Override
    public void paymentCancelled(PaymentResponse paymentResponse) {

    }
}

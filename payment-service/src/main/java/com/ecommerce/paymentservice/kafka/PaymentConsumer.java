package com.ecommerce.paymentservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @KafkaListener(topics = "order-payments", groupId = "payment-group")
    public void consumePaymentEvent(String message) {
        System.out.println("Received payment event: " + message);
        // Process payment logic here
    }
}

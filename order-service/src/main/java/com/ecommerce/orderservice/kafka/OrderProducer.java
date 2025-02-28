package com.ecommerce.orderservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.ecommerce.orderservice.entity.Order;

@Component
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendOrderEvent(Order order) {
        kafkaTemplate.send("order-topic", order);
    }
}

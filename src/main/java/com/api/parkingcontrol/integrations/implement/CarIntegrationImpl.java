package com.api.parkingcontrol.integrations.implement;

import com.api.parkingcontrol.common.enums.RabbitMQ;
import com.api.parkingcontrol.integrations.CarIntegration;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarIntegrationImpl implements CarIntegration {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void publisherMessage(String data) {
        String routing_key = RabbitMQ.QUEUE_CARS.name();
        Message message = new Message(data.getBytes());

        this.rabbitTemplate.send(routing_key, message);
    }
}

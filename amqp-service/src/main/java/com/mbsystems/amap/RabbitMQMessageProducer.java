package com.mbsystems.amap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish( Object payLoad, String exchange, String routingKey ) {
        log.info( "Publishing to {} using routingKey {}. Payload: {}", exchange, routingKey, payLoad );
        this.amqpTemplate.convertAndSend( exchange, routingKey, payLoad );
        log.info( "Published to {} using routingKey {}. Payload: {}", exchange, routingKey, payLoad );
    }
}

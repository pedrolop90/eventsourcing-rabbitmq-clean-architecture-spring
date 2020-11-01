package com.test.springboot.rabbitmq.infraestructura.consumer;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.Receiver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;

@Service
public class RabbitAdapter {

    private String queue = "equipo_agregado";
    private String exchange = "equipo";

    private final AmqpAdmin amqpAdmin;
    private final Mono<Connection> connectionMono;
    private final Receiver receiver;

    public RabbitAdapter(AmqpAdmin amqpAdmin, Mono<Connection> connectionMono, Receiver receiver) {
        this.amqpAdmin = amqpAdmin;
        this.connectionMono = connectionMono;
        this.receiver = receiver;
    }

    @PostConstruct
    public void init() {
        amqpAdmin.declareBinding(
                BindingBuilder
                        .bind(new Queue(queue, true, false, false))
                        .to(new FanoutExchange(exchange))
        );
    }

    @PreDestroy
    public void close() throws Exception {
        Objects.requireNonNull(connectionMono.block()).close();
    }

    public Flux<Delivery> receive() {
        return receiver.consumeAutoAck(queue);
    }

}

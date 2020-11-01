package com.test.springboot.rabbitmq.infraestructura.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.RabbitFlux;
import reactor.rabbitmq.Receiver;
import reactor.rabbitmq.ReceiverOptions;

@Configuration
public class RabbitConfig {

	@Bean
    Mono<Connection> connectionMono(RabbitProperties rabbitProperties) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost(rabbitProperties.getHost());
		connectionFactory.setPort(rabbitProperties.getPort());
		connectionFactory.setUsername(rabbitProperties.getUsername());
		connectionFactory.setPassword(rabbitProperties.getPassword());
		return Mono.fromCallable(() -> connectionFactory.newConnection("equipo_query")).cache();
	}

	@Bean
    Receiver receiver(Mono<Connection> connectionMono) {
		return RabbitFlux.createReceiver(new ReceiverOptions().connectionMono(connectionMono));
	}

}

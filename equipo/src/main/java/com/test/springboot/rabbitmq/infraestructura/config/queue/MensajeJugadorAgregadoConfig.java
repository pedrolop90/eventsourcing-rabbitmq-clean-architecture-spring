package com.test.springboot.rabbitmq.infraestructura.config.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pedro
 */
@Configuration
public class MensajeJugadorAgregadoConfig {

    public final static String COLA_JUGADOR_AGREGADO = "jugador_agregado";
    public final static String EXCHANGE_JUGADOR = "jugador";
    public final static String ROUTING_KEY_JUGADOR = "jugador_agregado";

    @Bean
    public Queue queueJugadorAgregado() {
        return new Queue(MensajeJugadorAgregadoConfig.COLA_JUGADOR_AGREGADO, false);
    }

    @Bean
    public FanoutExchange exchangeJugador() {
        return new FanoutExchange(MensajeJugadorAgregadoConfig.EXCHANGE_JUGADOR, false, true);
    }

    @Bean
    public Binding bindingJugadorAgregado(Queue queueJugadorAgregado, FanoutExchange exchangeJugador) {
        return BindingBuilder
                .bind(queueJugadorAgregado)
                .to(exchangeJugador);
    }

}

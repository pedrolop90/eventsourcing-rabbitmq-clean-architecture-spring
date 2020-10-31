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
public class MensajeJugadorEliminadoConfig {

    public final static String COLA_JUGADOR_ELIMINADO = "jugador_eliminado";
    public final static String ROUTING_KEY_JUGADOR = "jugador_eliminado";

    @Bean
    public Queue queueJugadorEliminado() {
        return new Queue(MensajeJugadorEliminadoConfig.COLA_JUGADOR_ELIMINADO, false);
    }

    @Bean
    public Binding bindingJugadorEliminado(Queue queueJugadorEliminado, FanoutExchange exchangeJugador) {
        return BindingBuilder
                .bind(queueJugadorEliminado)
                .to(exchangeJugador);
    }

}

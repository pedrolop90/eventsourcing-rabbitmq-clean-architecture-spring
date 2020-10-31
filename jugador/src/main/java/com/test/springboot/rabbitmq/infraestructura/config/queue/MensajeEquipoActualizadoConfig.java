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
public class MensajeEquipoActualizadoConfig {

    public final static String COLA_EQUIPO_ACTUALIZADO = "equipo_actualizado";
    public final static String EXCHANGE_EQUIPO = "equipo";
    public final static String ROUTING_KEY_EQUIPO = "equipo_actualizado";

    @Bean
    public Queue queueEquipo() {
        return new Queue(MensajeEquipoActualizadoConfig.COLA_EQUIPO_ACTUALIZADO, false);
    }

    @Bean
    public FanoutExchange exchangeEquipo() {
        return new FanoutExchange(MensajeEquipoActualizadoConfig.EXCHANGE_EQUIPO, false, true);
    }

    @Bean
    public Binding bindingEquipoActualizado(Queue queueEquipo, FanoutExchange exchangeEquipo) {
        return BindingBuilder
                .bind(queueEquipo)
                .to(exchangeEquipo);
    }

}

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
public class MensajeEquipoAgregadoConfig {

    public final static String COLA_EQUIPO_AGREGADO = "equipo_agregado";
    public final static String EXCHANGE_EQUIPO = "equipo";
    public final static String ROUTING_KEY_EQUIPO = "equipo_agregado";

    @Bean
    public Queue queueAgregado() {
        return new Queue(MensajeEquipoAgregadoConfig.COLA_EQUIPO_AGREGADO, false);
    }

    @Bean
    public FanoutExchange exchangeEquipo() {
        return new FanoutExchange(MensajeEquipoAgregadoConfig.EXCHANGE_EQUIPO, false, true);
    }

    @Bean
    public Binding bindingEquipoAgreado(Queue queueAgregado, FanoutExchange exchangeEquipo) {
        return BindingBuilder
                .bind(queueAgregado)
                .to(exchangeEquipo);
    }

}

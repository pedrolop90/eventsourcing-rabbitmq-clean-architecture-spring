package com.test.springboot.rabbitmq.infraestructura.producer;

import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import com.test.springboot.rabbitmq.dominio.domain.equipo.producer.EquipoProducer;
import com.test.springboot.rabbitmq.infraestructura.config.queue.MensajeEquipoActualizadoConfig;
import com.test.springboot.rabbitmq.infraestructura.config.queue.MensajeEquipoAgregadoConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Log4j2
@Component
@RequiredArgsConstructor
public class EquipoProducerAdapter implements EquipoProducer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void agregadoEquipo(Equipo equipo) {
        rabbitTemplate.convertAndSend(
                MensajeEquipoAgregadoConfig.EXCHANGE_EQUIPO,
                MensajeEquipoAgregadoConfig.ROUTING_KEY_EQUIPO,
                equipo
        );
        log.info(
                String.format(
                        "Equipo Agregado mensaje enviado === %s",
                        equipo.toString()
                )
        );
    }

    @Override
    public void actualizaDataEquipo(Equipo equipo) {
        rabbitTemplate.convertAndSend(
                MensajeEquipoActualizadoConfig.EXCHANGE_EQUIPO,
                MensajeEquipoActualizadoConfig.ROUTING_KEY_EQUIPO,
                equipo
        );
        log.info(
                String.format(
                        "Equipo Actualizado mensaje enviado === %s",
                        equipo.toString()
                )
        );
    }
}

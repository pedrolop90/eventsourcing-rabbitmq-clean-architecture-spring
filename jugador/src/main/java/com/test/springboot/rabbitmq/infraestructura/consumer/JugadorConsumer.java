package com.test.springboot.rabbitmq.infraestructura.consumer;

import com.test.springboot.rabbitmq.dominio.domain.jugador.equipo.Equipo;
import com.test.springboot.rabbitmq.infraestructura.config.queue.MensajeEquipoActualizadoConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
@RequiredArgsConstructor
public class JugadorConsumer {

    @RabbitListener(queues = MensajeEquipoActualizadoConfig.COLA_EQUIPO_ACTUALIZADO)
    public void equipoActualizado(Equipo equipo) {

    }


}

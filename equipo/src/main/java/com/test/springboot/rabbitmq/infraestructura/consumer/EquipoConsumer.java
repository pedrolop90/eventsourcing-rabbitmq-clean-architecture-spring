package com.test.springboot.rabbitmq.infraestructura.consumer;

import com.test.springboot.rabbitmq.application.service.equipo.EquipoService;
import com.test.springboot.rabbitmq.infraestructura.config.queue.MensajeJugadorAgregadoConfig;
import com.test.springboot.rabbitmq.infraestructura.config.queue.MensajeJugadorEliminadoConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
@RequiredArgsConstructor
public class EquipoConsumer {

    private final EquipoService equipoService;

    @RabbitListener(queues = MensajeJugadorAgregadoConfig.COLA_JUGADOR_AGREGADO)
    public void jugadorAgregado(AgregarJugador agregarJugador) {
        equipoService.agregarJugador(agregarJugador.getEquipoId(), agregarJugador.getCantidad());
    }


    @RabbitListener(queues = MensajeJugadorEliminadoConfig.COLA_JUGADOR_ELIMINADO)
    public void jugadorEliminado(AgregarJugador agregarJugador) {
        equipoService.eliminarJugador(agregarJugador.getEquipoId(), agregarJugador.getCantidad());
    }
}

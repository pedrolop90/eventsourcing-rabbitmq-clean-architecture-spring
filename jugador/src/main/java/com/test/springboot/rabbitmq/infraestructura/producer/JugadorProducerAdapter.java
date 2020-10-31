package com.test.springboot.rabbitmq.infraestructura.producer;

import com.test.springboot.rabbitmq.dominio.domain.jugador.producer.JugadorProducer;
import com.test.springboot.rabbitmq.infraestructura.config.queue.MensajeJugadorAgregadoConfig;
import com.test.springboot.rabbitmq.infraestructura.config.queue.MensajeJugadorEliminadoConfig;
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
public class JugadorProducerAdapter implements JugadorProducer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void agregarJugadorAEquipo(Long equipoId) {
        AgregarJugador agregarJugador = new AgregarJugador();
        agregarJugador.setCantidad(1L);
        agregarJugador.setEquipoId(equipoId);
        rabbitTemplate.convertAndSend(
                MensajeJugadorAgregadoConfig.EXCHANGE_JUGADOR,
                MensajeJugadorAgregadoConfig.ROUTING_KEY_JUGADOR,
                agregarJugador
        );
        log.info(
                String.format(
                        "JugadorAgregado mensaje enviado === %s",
                        agregarJugador.toString()
                )
        );
    }

    @Override
    public void EliminarJugadorDeEquipo(Long equipoId) {
        AgregarJugador agregarJugador = new AgregarJugador();
        agregarJugador.setCantidad(1L);
        agregarJugador.setEquipoId(equipoId);
        rabbitTemplate.convertAndSend(
                MensajeJugadorEliminadoConfig.EXCHANGE_JUGADOR,
                MensajeJugadorEliminadoConfig.ROUTING_KEY_JUGADOR,
                agregarJugador
        );
        log.info(
                String.format(
                        "JugadorEliminado mensaje enviado === %s",
                        agregarJugador.toString()
                )
        );
    }
}

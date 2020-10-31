package com.test.springboot.rabbitmq.dominio.domain.jugador.producer;

/**
 * @author pedro
 */
public interface JugadorProducer {

    void agregarJugadorAEquipo(Long equipoId);

    void EliminarJugadorDeEquipo(Long equipoId);
}

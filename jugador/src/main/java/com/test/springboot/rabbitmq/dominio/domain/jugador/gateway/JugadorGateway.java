package com.test.springboot.rabbitmq.dominio.domain.jugador.gateway;

import com.test.springboot.rabbitmq.dominio.domain.jugador.Jugador;
import com.test.springboot.rabbitmq.gateways.BaseGateway;

import java.util.stream.Stream;

/**
 * @author pedro
 */
public interface JugadorGateway extends BaseGateway<Jugador, Long> {

    Stream<Jugador> findByEquipoId(Long equipoId);

}

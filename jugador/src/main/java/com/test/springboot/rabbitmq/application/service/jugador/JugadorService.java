package com.test.springboot.rabbitmq.application.service.jugador;

import com.test.springboot.rabbitmq.application.service.BaseService;
import com.test.springboot.rabbitmq.dominio.domain.jugador.Jugador;
import com.test.springboot.rabbitmq.dominio.domain.jugador.equipo.Equipo;

/**
 * @author pedro
 */
public interface JugadorService extends BaseService<Jugador, Long> {

    void actualizarEquipo(Equipo equipo);

}

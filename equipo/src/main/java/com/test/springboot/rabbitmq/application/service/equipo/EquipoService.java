package com.test.springboot.rabbitmq.application.service.equipo;

import com.test.springboot.rabbitmq.application.service.BaseService;
import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;

/**
 * @author pedro
 */
public interface EquipoService extends BaseService<Equipo, Long> {

    void agregarJugador(Long equipoId, Long cantidadJugadores);

    void eliminarJugador(Long equipoId, Long cantidadJugadores);

}

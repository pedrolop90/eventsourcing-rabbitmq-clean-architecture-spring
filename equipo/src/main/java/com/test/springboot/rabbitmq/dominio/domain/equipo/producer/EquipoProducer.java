package com.test.springboot.rabbitmq.dominio.domain.equipo.producer;

import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;

/**
 * @author pedro
 */
public interface EquipoProducer {

    void agregadoEquipo(Equipo equipo);

    void actualizaDataEquipo(Equipo equipo);

}

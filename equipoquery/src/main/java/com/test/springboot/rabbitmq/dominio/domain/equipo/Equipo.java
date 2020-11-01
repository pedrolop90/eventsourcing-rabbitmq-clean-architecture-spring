package com.test.springboot.rabbitmq.dominio.domain.equipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author pedro
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Equipo {

    private Long id;
    private String nombre;
    private long cantidadJugadores;

}

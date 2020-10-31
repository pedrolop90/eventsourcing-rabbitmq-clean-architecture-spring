package com.test.springboot.rabbitmq.infraestructura.producer;

import lombok.Data;
import lombok.ToString;

/**
 * @author pedro
 */
@Data
@ToString
public class AgregarJugador {

    private Long equipoId;
    private Long cantidad;

}

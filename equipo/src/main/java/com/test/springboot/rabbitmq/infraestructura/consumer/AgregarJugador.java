package com.test.springboot.rabbitmq.infraestructura.consumer;

import lombok.Data;

/**
 * @author pedro
 */
@Data
public class AgregarJugador {

    private Long equipoId;
    private Long cantidad;

}

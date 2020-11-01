package com.test.springboot.rabbitmq.infraestructura.controller;

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
public class EquipoDto {

    private Long id;
    private String nombre;
    private long cantidadJugadores;

}

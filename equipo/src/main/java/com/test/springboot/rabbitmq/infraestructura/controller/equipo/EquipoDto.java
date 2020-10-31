package com.test.springboot.rabbitmq.infraestructura.controller.equipo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class EquipoDto {

    private Long id;
    private String nombre;
    private long cantidadJugadores;

}

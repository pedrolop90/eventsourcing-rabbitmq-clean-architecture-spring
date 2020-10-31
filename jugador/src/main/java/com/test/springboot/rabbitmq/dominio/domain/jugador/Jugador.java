package com.test.springboot.rabbitmq.dominio.domain.jugador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @author pedro
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Jugador {

    private Long id;
    private String nombre;
    private String cedula;
    private LocalDate fechaNacimiento;
    private Long equipoId;
    private String nombreEquipo;

}

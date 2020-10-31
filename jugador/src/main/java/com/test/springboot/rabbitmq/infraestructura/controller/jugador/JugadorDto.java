package com.test.springboot.rabbitmq.infraestructura.controller.jugador;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class JugadorDto {

    private Long id;
    private String nombre;
    private String cedula;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private Long equipoId;
    private String nombreEquipo;

}

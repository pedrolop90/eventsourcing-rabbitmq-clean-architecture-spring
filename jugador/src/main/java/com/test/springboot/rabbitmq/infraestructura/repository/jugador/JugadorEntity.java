package com.test.springboot.rabbitmq.infraestructura.repository.jugador;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author pedro
 */
@Data
@Entity
@Table(name = "jugador")
public class JugadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cedula;
    private LocalDate fecha;
    private Long equipoId;
    private String nombreEquipo;

}

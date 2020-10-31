package com.test.springboot.rabbitmq.infraestructura.repository.jugador;

import com.test.springboot.rabbitmq.dominio.domain.jugador.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

/**
 * @author pedro
 */
public interface JugadorRepository extends JpaRepository<JugadorEntity, Long> {

    Stream<Jugador> findByEquipoId(Long equipoId);

}

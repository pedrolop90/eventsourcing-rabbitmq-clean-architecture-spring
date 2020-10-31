package com.test.springboot.rabbitmq.dominio.usecase.equipo;

import com.test.springboot.rabbitmq.dominio.domain.jugador.Jugador;
import com.test.springboot.rabbitmq.dominio.domain.jugador.equipo.Equipo;
import com.test.springboot.rabbitmq.dominio.domain.jugador.gateway.JugadorGateway;
import com.test.springboot.rabbitmq.dominio.domain.jugador.producer.JugadorProducer;
import com.test.springboot.rabbitmq.usecase.impl.BaseUseCaseImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pedro
 */
@Service
public class JugadorCrudUseCase extends BaseUseCaseImpl<Jugador, Long, JugadorGateway> {

    private final JugadorProducer jugadorProducer;

    public JugadorCrudUseCase(JugadorGateway gateway, JugadorProducer jugadorProducer) {
        super(gateway);
        this.jugadorProducer = jugadorProducer;
    }

    @Override
    public Jugador insert(Jugador jugador) {
        Jugador jugadorResp = super.insert(jugador);
        jugadorProducer.agregarJugadorAEquipo(jugador.getEquipoId());
        return jugadorResp;
    }

    @Override
    public void delete(Long id) {
        Jugador jugador = gateway.findById(id);
        super.delete(id);
        jugadorProducer.EliminarJugadorDeEquipo(jugador.getEquipoId());
    }

    public void actualizarEquipo(Equipo equipo){
        List<Jugador> jugadores = gateway
                .findByEquipoId(equipo.getId())
                .map(jugador -> {
                    jugador.setNombreEquipo(equipo.getNombre());
                    return jugador;
                })
                .collect(Collectors.toList());
        gateway.insert(jugadores);
    }

}

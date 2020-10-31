package com.test.springboot.rabbitmq.application.service.jugador.impl;

import com.test.springboot.rabbitmq.application.service.jugador.JugadorService;
import com.test.springboot.rabbitmq.dominio.domain.jugador.Jugador;
import com.test.springboot.rabbitmq.dominio.domain.jugador.equipo.Equipo;
import com.test.springboot.rabbitmq.dominio.usecase.equipo.JugadorCrudUseCase;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
@Lazy
public class JugadorSeviceImpl
        extends BaseServiceImpl<Jugador, Long, JugadorCrudUseCase>
        implements JugadorService {

    public JugadorSeviceImpl(JugadorCrudUseCase jugadorCrudUseCase) {
        super(jugadorCrudUseCase);
    }

    @Override
    public void actualizarEquipo(Equipo equipo) {
        usecase.actualizarEquipo(equipo);
    }
}

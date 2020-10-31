package com.test.springboot.rabbitmq.application.service.equipo.impl;

import com.test.springboot.rabbitmq.application.service.equipo.EquipoService;
import com.test.springboot.rabbitmq.application.service.jugador.impl.BaseServiceImpl;
import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import com.test.springboot.rabbitmq.dominio.usecase.equipo.EquipoCrudUseCase;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author pedro
 */
@Service
@Lazy
public class EquipoServiceImpl
        extends BaseServiceImpl<Equipo, Long, EquipoCrudUseCase>
        implements EquipoService {
    public EquipoServiceImpl(EquipoCrudUseCase equipoCrudUseCase) {
        super(equipoCrudUseCase);
    }

    @Override
    public void agregarJugador(Long equipoId, Long cantidadJugadores) {
        usecase.agregarJugador(equipoId, cantidadJugadores);
    }

    @Override
    public void eliminarJugador(Long equipoId, Long cantidadJugadores) {
        usecase.eliminarJugador(equipoId, cantidadJugadores);
    }
}

package com.test.springboot.rabbitmq.dominio.usecase.equipo;

import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import com.test.springboot.rabbitmq.dominio.domain.equipo.gateway.EquipoGateway;
import com.test.springboot.rabbitmq.dominio.domain.equipo.producer.EquipoProducer;
import com.test.springboot.rabbitmq.usecase.impl.BaseUseCaseImpl;
import org.springframework.stereotype.Service;

/**
 * @author pedro
 */
@Service
public class EquipoCrudUseCase extends BaseUseCaseImpl<Equipo, Long, EquipoGateway> {

    private final EquipoProducer equipoProducer;

    public EquipoCrudUseCase(EquipoGateway gateway, EquipoProducer equipoProducer) {
        super(gateway);
        this.equipoProducer = equipoProducer;
    }

    @Override
    public Equipo insert(Equipo equipo) {
        Equipo equipoResp = super.insert(equipo);
        equipoProducer.actualizaDataEquipo(equipoResp);
        return equipoResp;
    }

    public void agregarJugador(Long equipoId, Long cantidadJugadores) {
        Equipo equipo = gateway.findById(equipoId);
        equipo.setCantidadJugadores(equipo.getCantidadJugadores() + cantidadJugadores);
        gateway.update(equipo);
    }

    public void eliminarJugador(Long equipoId, Long cantidadJugadores) {
        Equipo equipo = gateway.findById(equipoId);
        equipo.setCantidadJugadores(equipo.getCantidadJugadores() - cantidadJugadores);
        gateway.update(equipo);
    }
}

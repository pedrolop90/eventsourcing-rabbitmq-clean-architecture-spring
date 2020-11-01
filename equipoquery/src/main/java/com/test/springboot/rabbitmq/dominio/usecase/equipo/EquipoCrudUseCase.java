package com.test.springboot.rabbitmq.dominio.usecase.equipo;

import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import com.test.springboot.rabbitmq.dominio.domain.equipo.gateway.EquipoGateway;
import com.test.springboot.rabbitmq.usecase.impl.BaseUseCaseImpl;
import org.springframework.stereotype.Service;

/**
 * @author pedro
 */
@Service
public class EquipoCrudUseCase extends BaseUseCaseImpl<Equipo, Long, EquipoGateway> {

    public EquipoCrudUseCase(EquipoGateway gateway) {
        super(gateway);
    }
}

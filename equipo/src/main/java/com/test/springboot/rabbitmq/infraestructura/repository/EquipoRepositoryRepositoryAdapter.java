package com.test.springboot.rabbitmq.infraestructura.repository;

import com.test.springboot.rabbitmq.adapter.BaseRepositoryAdapterImpl;
import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import com.test.springboot.rabbitmq.dominio.domain.equipo.gateway.EquipoGateway;
import org.springframework.stereotype.Repository;

/**
 * @author pedro
 */
@Repository
public class EquipoRepositoryRepositoryAdapter
        extends BaseRepositoryAdapterImpl<Equipo, EquipoEntity, Long, EquipoMapper>
        implements EquipoGateway {

    private final EquipoRepository equipoRepository;

    public EquipoRepositoryRepositoryAdapter(EquipoMapper mapper, EquipoRepository equipoRepository) {
        super(mapper);
        this.equipoRepository = equipoRepository;
    }

    @Override
    protected EquipoRepository getRepository() {
        return equipoRepository;
    }
}

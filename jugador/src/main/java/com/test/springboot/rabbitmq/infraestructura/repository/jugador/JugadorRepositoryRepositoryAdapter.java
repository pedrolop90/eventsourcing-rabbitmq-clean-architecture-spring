package com.test.springboot.rabbitmq.infraestructura.repository.jugador;

import com.test.springboot.rabbitmq.adapter.BaseRepositoryAdapterImpl;
import com.test.springboot.rabbitmq.dominio.domain.jugador.Jugador;
import com.test.springboot.rabbitmq.dominio.domain.jugador.gateway.JugadorGateway;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

/**
 * @author pedro
 */
@Repository
public class JugadorRepositoryRepositoryAdapter
        extends BaseRepositoryAdapterImpl<Jugador, JugadorEntity, Long, JugadorMapper>
        implements JugadorGateway {

    private final JugadorRepository jugadorRepository;

    public JugadorRepositoryRepositoryAdapter(JugadorMapper mapper, JugadorRepository jugadorRepository) {
        super(mapper);
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    protected JugadorRepository getRepository() {
        return jugadorRepository;
    }

    @Override
    public Stream<Jugador> findByEquipoId(Long equipoId) {
        return jugadorRepository.findByEquipoId(equipoId);
    }
}

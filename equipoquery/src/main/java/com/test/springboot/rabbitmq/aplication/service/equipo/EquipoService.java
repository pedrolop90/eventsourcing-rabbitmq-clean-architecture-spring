package com.test.springboot.rabbitmq.aplication.service.equipo;

import com.test.springboot.rabbitmq.application.service.BaseService;
import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import reactor.core.publisher.Flux;

/**
 * @author pedro
 */
public interface EquipoService extends BaseService<Equipo, Long> {

    Flux<Equipo> stream(String cliente);

    void crearCliente(String cliente);

}

package com.test.springboot.rabbitmq.infraestructura.repository.jugador;

import com.test.springboot.rabbitmq.dominio.domain.jugador.Jugador;
import com.test.springboot.rabbitmq.mapper.BaseMapper;
import org.mapstruct.Mapper;

/**
 * @author pedro
 */
@Mapper(componentModel = "spring")
public interface JugadorMapper extends BaseMapper<Jugador, JugadorEntity> {
}

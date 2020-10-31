package com.test.springboot.rabbitmq.infraestructura.controller.jugador;

import com.test.springboot.rabbitmq.dominio.domain.jugador.Jugador;
import com.test.springboot.rabbitmq.mapper.BaseMapper;
import org.mapstruct.Mapper;

/**
 * @author pedro
 */
@Mapper(componentModel = "spring")
public interface JugadorDtoMapper extends BaseMapper<JugadorDto, Jugador> {

}

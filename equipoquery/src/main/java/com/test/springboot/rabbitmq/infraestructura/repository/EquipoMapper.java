package com.test.springboot.rabbitmq.infraestructura.repository;

import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import com.test.springboot.rabbitmq.mapper.BaseMapper;
import org.mapstruct.Mapper;

/**
 * @author pedro
 */
@Mapper(componentModel = "spring")
public interface EquipoMapper extends BaseMapper<Equipo, EquipoEntity> {
}

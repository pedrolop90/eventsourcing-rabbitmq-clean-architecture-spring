package com.test.springboot.rabbitmq.infraestructura.controller.equipo;

import com.test.springboot.rabbitmq.application.service.equipo.EquipoService;
import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import com.test.springboot.rabbitmq.infraestructura.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pedro
 */
@RestController
@RequestMapping("equipo")
public class EquipoController
        extends BaseController<Long, EquipoDto, Equipo, EquipoDtoMapper, EquipoService> {
    public EquipoController(EquipoDtoMapper mapper, EquipoService service) {
        super(mapper, service);
    }
}

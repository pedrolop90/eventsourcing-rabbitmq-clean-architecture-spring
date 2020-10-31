package com.test.springboot.rabbitmq.infraestructura.controller.jugador;

import com.test.springboot.rabbitmq.application.service.jugador.JugadorService;
import com.test.springboot.rabbitmq.dominio.domain.jugador.Jugador;
import com.test.springboot.rabbitmq.infraestructura.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pedro
 */
@RestController
@RequestMapping("/jugador")
public class JugadorController
        extends BaseController<Long, JugadorDto, Jugador, JugadorDtoMapper, JugadorService> {

    public JugadorController(JugadorDtoMapper mapper, JugadorService service) {
        super(mapper, service);
    }
}

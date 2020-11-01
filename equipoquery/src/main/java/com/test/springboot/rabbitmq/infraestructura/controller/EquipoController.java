package com.test.springboot.rabbitmq.infraestructura.controller;

import com.test.springboot.rabbitmq.aplication.service.equipo.EquipoService;
import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author pedro
 */
@RestController
@RequestMapping("equipo")
@RequiredArgsConstructor
@CrossOrigin
public class EquipoController {

    private final EquipoService equipoService;
    private final EquipoDtoMapper equipoDtoMapper;

    @GetMapping
    public List<EquipoDto> findAll() {
        List<Equipo> equipos = equipoService.findAll().collect(Collectors.toList());
        return equipoDtoMapper.rightToLeft(equipos).collect(Collectors.toList());
    }

    @GetMapping("/stream/{nombreCliente}")
    public Flux<ServerSentEvent<EquipoDto>> stream(
            @PathVariable String nombreCliente
    ) {
        return Flux.interval(Duration.ofMillis(100))
                .doOnNext(aLong -> equipoService.crearCliente(nombreCliente))
                .onBackpressureBuffer()
                .flatMap(interval -> equipoService.stream(nombreCliente))
                .map(equipo -> equipoDtoMapper.rightToLeft(equipo))
                .doOnNext(equipoDto -> System.out.println(
                        String.format(
                                "se va la info %s al cliente %s",
                                equipoDto.toString(),
                                nombreCliente
                        )
                ))
                .map(equipoDto ->
                        ServerSentEvent.<EquipoDto>builder()
                                .data(equipoDto)
                                .id(UUID.randomUUID().toString())
                                .build()
                )
                ;
    }

}

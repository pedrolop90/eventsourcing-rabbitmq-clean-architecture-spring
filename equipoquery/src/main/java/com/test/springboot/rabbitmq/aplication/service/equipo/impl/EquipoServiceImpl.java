package com.test.springboot.rabbitmq.aplication.service.equipo.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Delivery;
import com.test.springboot.rabbitmq.aplication.service.equipo.EquipoService;
import com.test.springboot.rabbitmq.application.service.jugador.impl.BaseServiceImpl;
import com.test.springboot.rabbitmq.dominio.domain.equipo.Equipo;
import com.test.springboot.rabbitmq.dominio.usecase.equipo.EquipoCrudUseCase;
import com.test.springboot.rabbitmq.infraestructura.consumer.RabbitAdapter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author pedro
 */
@Log4j2
@Service
public class EquipoServiceImpl
        extends BaseServiceImpl<Equipo, Long, EquipoCrudUseCase>
        implements EquipoService {

    private Map<String, ConcurrentLinkedQueue<Equipo>> eventQueue;
    private final RabbitAdapter rabbitAdapter;
    private final ObjectMapper objectMapper;

    public EquipoServiceImpl(EquipoCrudUseCase equipoCrudUseCase,
                             RabbitAdapter rabbitAdapter) {
        super(equipoCrudUseCase);
        this.rabbitAdapter = rabbitAdapter;

        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        eventQueue = new HashMap<>();
    }

    @PostConstruct
    public void ingest() {
        rabbitAdapter.receive()
                .doOnNext(this::logDelivery)
                .flatMap(delivery -> Mono.fromCallable(() -> objectMapper.readValue(delivery.getBody(), Equipo.class)))
                .map(usecase::insert)
                .doOnNext(equipo -> {
                    eventQueue.forEach((s, equipos) -> {
                        equipos.add(equipo);
                    });
                })
                .subscribe();
    }

    @Override
    public Flux<Equipo> stream(String cliente) {
        return Flux.fromArray(eventQueue.get(cliente).toArray(new Equipo[]{}))
                .switchIfEmpty(Mono.empty())
                .doOnNext(equipo -> log.info("Stream: {}", equipo.toString()))
                .doOnComplete(() -> eventQueue.get(cliente).clear());
    }

    @Override
    public void crearCliente(String cliente) {
        eventQueue.computeIfAbsent(cliente, s -> new ConcurrentLinkedQueue());
    }

    private void logDelivery(Delivery delivery) {
        log.info(
                "Mensaje recibido -> Cola: {} - Mensaje: {}",
                delivery.getEnvelope().getRoutingKey(),
                new String(delivery.getBody(), StandardCharsets.UTF_8)
        );
    }
}

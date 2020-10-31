package com.test.springboot.rabbitmq.infraestructura.controller;

import com.test.springboot.rabbitmq.application.service.BaseService;
import com.test.springboot.rabbitmq.mapper.BaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pedro
 */
@RequiredArgsConstructor
public class BaseController
        <ID,
                DTO,
                DOMAIN,
                MAPPER extends BaseMapper<DTO, DOMAIN>,
                SERVICE extends BaseService<DOMAIN, ID>
                > {

    protected final MAPPER mapper;
    protected final SERVICE service;

    @PostMapping
    private DTO insert(DTO dto) {
        DOMAIN domain = mapper.leftToRight(dto);
        DOMAIN resp = service.insert(domain);
        return mapper.rightToLeft(resp);
    }

    @PutMapping
    private DTO update(DTO dto) {
        DOMAIN domain = mapper.leftToRight(dto);
        DOMAIN resp = service.insert(domain);
        return mapper.rightToLeft(resp);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable ID id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    private DTO findById(@PathVariable ID id) {
        DOMAIN domain = service.findById(id);
        return mapper.rightToLeft(domain);
    }


    @GetMapping
    private List<DTO> findAll() {
        Stream<DOMAIN> domains = service.findAll();
        return mapper
                .rightToLeft(
                        domains.collect(Collectors.toList())
                )
                .collect(Collectors.toList());
    }

}

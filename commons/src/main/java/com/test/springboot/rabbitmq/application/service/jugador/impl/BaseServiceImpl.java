package com.test.springboot.rabbitmq.application.service.jugador.impl;

import com.test.springboot.rabbitmq.application.service.BaseService;
import com.test.springboot.rabbitmq.usecase.BaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author pedro
 */
@Service
@Primary
@RequiredArgsConstructor
public abstract class BaseServiceImpl<DOMAIN, ID, USECASE extends BaseUseCase<DOMAIN, ID>>
        implements BaseService<DOMAIN, ID> {

    protected final USECASE usecase;

    @Override
    public DOMAIN insert(DOMAIN domain) {
        return usecase.insert(domain);
    }

    @Override
    public DOMAIN update(DOMAIN domain) {
        return usecase.update(domain);
    }

    @Override
    public void delete(ID id) {
        usecase.delete(id);
    }

    @Override
    public DOMAIN findById(ID id) {
        return usecase.findById(id);
    }

    @Override
    public Stream<DOMAIN> findAll() {
        return usecase.findAll();
    }
}

package com.test.springboot.rabbitmq.usecase.impl;

import com.test.springboot.rabbitmq.gateways.BaseGateway;
import com.test.springboot.rabbitmq.usecase.BaseUseCase;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

/**
 * @author pedro
 */
@RequiredArgsConstructor
public class BaseUseCaseImpl<DOMAIN, ID, GATEWAY extends BaseGateway<DOMAIN, ID>>
        implements BaseUseCase<DOMAIN, ID> {

    protected final GATEWAY gateway;

    @Override
    public DOMAIN insert(DOMAIN domain) {
        return gateway.insert(domain);
    }

    @Override
    public DOMAIN update(DOMAIN domain) {
        return gateway.update(domain);
    }

    @Override
    public void delete(ID id) {
        gateway.delete(id);
    }

    @Override
    public DOMAIN findById(ID id) {
        return gateway.findById(id);
    }

    @Override
    public Stream<DOMAIN> findAll() {
        return gateway.findAll();
    }
}

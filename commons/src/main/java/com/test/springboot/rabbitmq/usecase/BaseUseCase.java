package com.test.springboot.rabbitmq.usecase;

import java.util.stream.Stream;

/**
 * @author pedro
 */
public interface BaseUseCase<DOMAIN, ID> {

    DOMAIN insert(DOMAIN domain);

    DOMAIN update(DOMAIN domain);

    void delete(ID id);

    DOMAIN findById(ID id);

    Stream<DOMAIN> findAll();

}

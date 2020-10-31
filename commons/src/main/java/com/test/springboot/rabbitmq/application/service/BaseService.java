package com.test.springboot.rabbitmq.application.service;

import java.util.stream.Stream;

/**
 * @author pedro
 */
public interface BaseService<DOMAIN, ID> {

    DOMAIN insert(DOMAIN domain);

    DOMAIN update(DOMAIN domain);

    void delete(ID id);

    DOMAIN findById(ID id);

    Stream<DOMAIN> findAll();

}

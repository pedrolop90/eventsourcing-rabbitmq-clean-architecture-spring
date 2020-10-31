package com.test.springboot.rabbitmq.gateways;

import java.util.stream.Stream;

/**
 * @author pedro
 */
public interface BaseGateway<DOMAIN, ID> {

    DOMAIN insert(DOMAIN domain);

    Stream<DOMAIN> insert(Iterable<DOMAIN> domain);

    DOMAIN update(DOMAIN domain);

    void delete(ID id);

    DOMAIN findById(ID id);

    Stream<DOMAIN> findAll();

}

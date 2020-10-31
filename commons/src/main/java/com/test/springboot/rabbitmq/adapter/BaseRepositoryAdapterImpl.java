package com.test.springboot.rabbitmq.adapter;

import com.test.springboot.rabbitmq.gateways.BaseGateway;
import com.test.springboot.rabbitmq.mapper.BaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pedro
 */
@RequiredArgsConstructor
public abstract class BaseRepositoryAdapterImpl<DOMAIN, ENTITY, ID, MAPPER extends BaseMapper<DOMAIN, ENTITY>>
        implements BaseGateway<DOMAIN, ID> {

    protected final MAPPER mapper;

    @Override
    public DOMAIN insert(DOMAIN domain) {
        ENTITY entity = mapper.leftToRight(domain);
        getRepository().save(entity);
        return mapper.rightToLeft(entity);
    }

    @Override
    public Stream<DOMAIN> insert(Iterable<DOMAIN> domain) {
        Collection<ENTITY> entities = mapper.leftToRight(domain).collect(Collectors.toList());
        Iterable<ENTITY> entitiesResp = getRepository().saveAll(entities);
        return mapper.rightToLeft(entitiesResp);
    }

    @Override
    public DOMAIN update(DOMAIN domain) {
        ENTITY entity = mapper.leftToRight(domain);
        getRepository().save(entity);
        return mapper.rightToLeft(entity);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public DOMAIN findById(ID id) {
        return getRepository()
                .findById(id)
                .filter(entity -> entity != null)
                .map(mapper::rightToLeft)
                .orElse(null);
    }

    @Override
    public Stream<DOMAIN> findAll() {
        Iterable<ENTITY> entities = getRepository().findAll();
        return mapper.rightToLeft(entities);
    }

    protected abstract CrudRepository<ENTITY, ID> getRepository();
}

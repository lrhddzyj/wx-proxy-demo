package com.mind.weixin.utils;

import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by serv on 2014/7/11.
 */
@Component
@Scope(value = "prototype")
public class BeanMapper extends ConfigurableMapper {
    @Override
    protected void configureFactoryBuilder(DefaultMapperFactory.Builder factoryBuilder) {
        factoryBuilder.mapNulls(false);
    }
}

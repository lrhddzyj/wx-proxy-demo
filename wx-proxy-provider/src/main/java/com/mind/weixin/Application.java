package com.mind.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by serv on 2014/11/17.
 */
@Configuration
@ComponentScan(basePackages = "com.mind")
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "com.mind.weixin.entity")
@ImportResource("classpath:dubbo.xml")
public class Application {

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        return new StringRedisTemplate(redisConnectionFactory);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}

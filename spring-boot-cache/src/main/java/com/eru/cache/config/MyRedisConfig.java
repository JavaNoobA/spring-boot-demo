package com.eru.cache.config;

import com.eru.cache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * Created by eru on 2020/3/7.
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Employee> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<>(Employee.class);
        redisTemplate.setDefaultSerializer(serializer);
        return redisTemplate;
    }

    @Bean
    public RedisCacheManager empCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
                // 设置缓存时间
                .entryTtl(Duration.ofDays(1))
                // 禁用空值缓存
                .disableCachingNullValues()
                // 设置json序列化方式
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(
                                new GenericJackson2JsonRedisSerializer()));

        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(defaultConfig).build();
    }
}

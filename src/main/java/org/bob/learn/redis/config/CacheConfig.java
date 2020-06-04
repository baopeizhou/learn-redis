package org.bob.learn.redis.config;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class CacheConfig {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Bean(CacheManagerName.CAFFEINE_CACHE_MANAGER)
    public CaffeineCacheManager caffeineCacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        return caffeineCacheManager;
    }

     final static class CacheManagerName{

         public static final String  REDIS_CACHE_MANAGER = "redisCacheManager";

         public static final String  CAFFEINE_CACHE_MANAGER = "caffeineCacheManager";
     }
}

package com.nwafu.catmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableRedisHttpSession     //开启springsession
@EnableCaching      //开启缓存功能
@EnableFeignClients(basePackages = "com.nwafu.catmall.product.feign")
@EnableDiscoveryClient
@MapperScan("com.nwafu.catmall.product.dao")
@SpringBootApplication
public class CatmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatmallProductApplication.class, args);
    }

}

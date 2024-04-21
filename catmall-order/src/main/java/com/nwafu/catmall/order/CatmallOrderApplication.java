package com.nwafu.catmall.order;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableAspectJAutoProxy(exposeProxy = true)     //开启了aspect动态代理模式,对外暴露代理对象
@EnableRedisHttpSession     //开启springsession
@EnableRabbit
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient  //开启nacos发现
public class CatmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatmallOrderApplication.class, args);
    }

}

package com.nwafu.catmall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient  //开启nacos发现
@EnableFeignClients     //开启feign功能
public class CatmallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatmallWareApplication.class, args);
    }

}

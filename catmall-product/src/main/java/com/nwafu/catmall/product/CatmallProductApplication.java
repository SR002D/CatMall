package com.nwafu.catmall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient  //开启nacos发现
@EnableFeignClients("com.nwafu.catmall.product.feign")  // 开启feign远程调用
public class CatmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatmallProductApplication.class, args);
    }

}

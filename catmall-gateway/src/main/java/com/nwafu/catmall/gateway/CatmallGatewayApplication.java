package com.nwafu.catmall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CatmallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatmallGatewayApplication.class, args);
    }

}

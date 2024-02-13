package com.nwafu.catmall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //开启nacos发现
public class CatmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatmallOrderApplication.class, args);
    }

}

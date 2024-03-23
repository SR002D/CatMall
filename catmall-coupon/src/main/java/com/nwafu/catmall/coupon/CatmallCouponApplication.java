package com.nwafu.catmall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient  //开启nacos发现
@EnableFeignClients(basePackages = "com.nwafu.catmall.coupon.feign")    // 开启feign功能
public class CatmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatmallCouponApplication.class, args);
    }

}

package com.nwafu.catmall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.nwafu.catmall.member.feign")   // 开启feign扫描
@EnableDiscoveryClient  //开启nacos发现
public class CatmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatmallMemberApplication.class, args);
    }

}

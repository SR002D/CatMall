package com.nwafu.catmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.nwafu.catmall.product.dao")
@SpringBootApplication
public class CatmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatmallProductApplication.class, args);
    }

}

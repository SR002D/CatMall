package com.nwafu.catmall.product;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nwafu.catmall.product.entity.BrandEntity;
import com.nwafu.catmall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CatmallProductApplicationTests {
    @Autowired
    BrandService brandService;
    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        LambdaQueryWrapper<BrandEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BrandEntity::getName,"华为");
        System.out.println(brandService.list(queryWrapper).toString());
    }
}

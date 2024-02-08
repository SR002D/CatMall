package com.nwafu.catmall.product.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.product.dao.BrandDao;
import com.nwafu.catmall.product.entity.BrandEntity;
import com.nwafu.catmall.product.service.BrandService;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

}
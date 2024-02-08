package com.nwafu.catmall.coupon.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.coupon.dao.SkuFullReductionDao;
import com.nwafu.catmall.coupon.entity.SkuFullReductionEntity;
import com.nwafu.catmall.coupon.service.SkuFullReductionService;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

}
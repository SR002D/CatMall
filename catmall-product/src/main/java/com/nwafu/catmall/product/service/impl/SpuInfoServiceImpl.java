package com.nwafu.catmall.product.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.product.dao.SpuInfoDao;
import com.nwafu.catmall.product.entity.SpuInfoEntity;
import com.nwafu.catmall.product.service.SpuInfoService;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

}
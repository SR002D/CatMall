package com.nwafu.catmall.ware.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.ware.dao.WareSkuDao;
import com.nwafu.catmall.ware.entity.WareSkuEntity;
import com.nwafu.catmall.ware.service.WareSkuService;


@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {

}
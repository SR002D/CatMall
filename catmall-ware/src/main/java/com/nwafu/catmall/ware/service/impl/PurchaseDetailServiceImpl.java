package com.nwafu.catmall.ware.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.ware.dao.PurchaseDetailDao;
import com.nwafu.catmall.ware.entity.PurchaseDetailEntity;
import com.nwafu.catmall.ware.service.PurchaseDetailService;


@Service("purchaseDetailService")
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailDao, PurchaseDetailEntity> implements PurchaseDetailService {

}
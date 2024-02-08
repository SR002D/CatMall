package com.nwafu.catmall.order.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.order.dao.RefundInfoDao;
import com.nwafu.catmall.order.entity.RefundInfoEntity;
import com.nwafu.catmall.order.service.RefundInfoService;


@Service("refundInfoService")
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoDao, RefundInfoEntity> implements RefundInfoService {

}
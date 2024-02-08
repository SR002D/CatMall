package com.nwafu.catmall.order.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.order.dao.OrderSettingDao;
import com.nwafu.catmall.order.entity.OrderSettingEntity;
import com.nwafu.catmall.order.service.OrderSettingService;


@Service("orderSettingService")
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingDao, OrderSettingEntity> implements OrderSettingService {

}
package com.nwafu.catmall.order.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.order.dao.OrderItemDao;
import com.nwafu.catmall.order.entity.OrderItemEntity;
import com.nwafu.catmall.order.service.OrderItemService;


@Service("orderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {

}
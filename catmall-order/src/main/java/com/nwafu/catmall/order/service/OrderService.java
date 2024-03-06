package com.nwafu.catmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwafu.common.utils.PageUtils;
import com.nwafu.catmall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 11:01:11
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


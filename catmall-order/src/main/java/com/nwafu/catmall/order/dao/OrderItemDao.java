package com.nwafu.catmall.order.dao;

import com.nwafu.catmall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-02-08 22:01:04
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}

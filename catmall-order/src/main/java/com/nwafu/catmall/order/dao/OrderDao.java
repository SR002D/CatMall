package com.nwafu.catmall.order.dao;

import com.nwafu.catmall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-02-08 22:01:04
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}

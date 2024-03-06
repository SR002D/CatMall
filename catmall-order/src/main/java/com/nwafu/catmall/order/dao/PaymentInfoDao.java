package com.nwafu.catmall.order.dao;

import com.nwafu.catmall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 11:01:11
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}

package com.nwafu.catmall.coupon.dao;

import com.nwafu.catmall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 10:56:39
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}

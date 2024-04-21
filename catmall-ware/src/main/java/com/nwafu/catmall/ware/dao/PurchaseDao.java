package com.nwafu.catmall.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwafu.catmall.ware.entity.PurchaseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}

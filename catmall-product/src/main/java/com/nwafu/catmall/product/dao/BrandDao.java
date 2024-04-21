package com.nwafu.catmall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwafu.catmall.product.entity.BrandEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}

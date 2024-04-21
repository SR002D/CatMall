package com.nwafu.catmall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwafu.catmall.product.entity.ProductAttrValueEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * spu属性值
 */
@Mapper
public interface ProductAttrValueDao extends BaseMapper<ProductAttrValueEntity> {
	
}

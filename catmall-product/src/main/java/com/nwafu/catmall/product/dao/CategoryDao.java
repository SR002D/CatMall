package com.nwafu.catmall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwafu.catmall.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}

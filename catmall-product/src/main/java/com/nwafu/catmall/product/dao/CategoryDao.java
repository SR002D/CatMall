package com.nwafu.catmall.product.dao;

import com.nwafu.catmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 10:58:25
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}

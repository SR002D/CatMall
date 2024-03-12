package com.nwafu.catmall.product.dao;

import com.nwafu.catmall.product.entity.AttrAttrgroupRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性&属性分组关联
 * 
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 10:58:25
 */
@Mapper
public interface AttrAttrgroupRelationDao extends BaseMapper<AttrAttrgroupRelationEntity> {

    void deleteBatchRelation(@Param("entites")List<AttrAttrgroupRelationEntity> entities);
}

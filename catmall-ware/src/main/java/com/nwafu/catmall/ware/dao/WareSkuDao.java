package com.nwafu.catmall.ware.dao;

import com.nwafu.catmall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品库存
 * 
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 10:33:18
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

    void addStock(@Param("skuId") Long skuId,
                  @Param("wareId")Long wareId,
                  @Param("skuNum")Integer skuNum);
}

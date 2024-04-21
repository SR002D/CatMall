package com.nwafu.catmall.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwafu.catmall.ware.entity.WareInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}

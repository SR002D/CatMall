package com.nwafu.catmall.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwafu.catmall.member.entity.MemberCollectSpuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员收藏的商品
 */
@Mapper
public interface MemberCollectSpuDao extends BaseMapper<MemberCollectSpuEntity> {
	
}

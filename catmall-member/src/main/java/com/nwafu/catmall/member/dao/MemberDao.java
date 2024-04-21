package com.nwafu.catmall.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwafu.catmall.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}

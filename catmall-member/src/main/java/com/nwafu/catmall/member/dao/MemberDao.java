package com.nwafu.catmall.member.dao;

import com.nwafu.catmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-02-08 21:58:22
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}

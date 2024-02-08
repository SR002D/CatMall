package com.nwafu.catmall.member.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.member.dao.MemberLevelDao;
import com.nwafu.catmall.member.entity.MemberLevelEntity;
import com.nwafu.catmall.member.service.MemberLevelService;


@Service("memberLevelService")
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelDao, MemberLevelEntity> implements MemberLevelService {

}
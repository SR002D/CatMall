package com.nwafu.catmall.member.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.member.dao.MemberDao;
import com.nwafu.catmall.member.entity.MemberEntity;
import com.nwafu.catmall.member.service.MemberService;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

}
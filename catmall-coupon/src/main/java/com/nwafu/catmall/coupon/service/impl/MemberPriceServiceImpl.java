package com.nwafu.catmall.coupon.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.coupon.dao.MemberPriceDao;
import com.nwafu.catmall.coupon.entity.MemberPriceEntity;
import com.nwafu.catmall.coupon.service.MemberPriceService;


@Service("memberPriceService")
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceDao, MemberPriceEntity> implements MemberPriceService {

}
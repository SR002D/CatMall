package com.nwafu.catmall.coupon.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.coupon.dao.CouponDao;
import com.nwafu.catmall.coupon.entity.CouponEntity;
import com.nwafu.catmall.coupon.service.CouponService;


@Service("couponService")
public class CouponServiceImpl extends ServiceImpl<CouponDao, CouponEntity> implements CouponService {

}
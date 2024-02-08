package com.nwafu.catmall.coupon.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.coupon.dao.CouponSpuRelationDao;
import com.nwafu.catmall.coupon.entity.CouponSpuRelationEntity;
import com.nwafu.catmall.coupon.service.CouponSpuRelationService;


@Service("couponSpuRelationService")
public class CouponSpuRelationServiceImpl extends ServiceImpl<CouponSpuRelationDao, CouponSpuRelationEntity> implements CouponSpuRelationService {

}
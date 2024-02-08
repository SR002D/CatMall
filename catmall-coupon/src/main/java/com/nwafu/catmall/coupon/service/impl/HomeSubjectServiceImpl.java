package com.nwafu.catmall.coupon.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.coupon.dao.HomeSubjectDao;
import com.nwafu.catmall.coupon.entity.HomeSubjectEntity;
import com.nwafu.catmall.coupon.service.HomeSubjectService;


@Service("homeSubjectService")
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectDao, HomeSubjectEntity> implements HomeSubjectService {

}
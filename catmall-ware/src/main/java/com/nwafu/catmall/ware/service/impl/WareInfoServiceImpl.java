package com.nwafu.catmall.ware.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.ware.dao.WareInfoDao;
import com.nwafu.catmall.ware.entity.WareInfoEntity;
import com.nwafu.catmall.ware.service.WareInfoService;


@Service("wareInfoService")
public class WareInfoServiceImpl extends ServiceImpl<WareInfoDao, WareInfoEntity> implements WareInfoService {

}
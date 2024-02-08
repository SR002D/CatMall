package com.nwafu.catmall.ware.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.ware.dao.WareOrderTaskDetailDao;
import com.nwafu.catmall.ware.entity.WareOrderTaskDetailEntity;
import com.nwafu.catmall.ware.service.WareOrderTaskDetailService;


@Service("wareOrderTaskDetailService")
public class WareOrderTaskDetailServiceImpl extends ServiceImpl<WareOrderTaskDetailDao, WareOrderTaskDetailEntity> implements WareOrderTaskDetailService {

}
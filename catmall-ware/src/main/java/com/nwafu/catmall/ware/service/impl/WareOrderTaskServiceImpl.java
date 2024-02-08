package com.nwafu.catmall.ware.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.ware.dao.WareOrderTaskDao;
import com.nwafu.catmall.ware.entity.WareOrderTaskEntity;
import com.nwafu.catmall.ware.service.WareOrderTaskService;


@Service("wareOrderTaskService")
public class WareOrderTaskServiceImpl extends ServiceImpl<WareOrderTaskDao, WareOrderTaskEntity> implements WareOrderTaskService {

}
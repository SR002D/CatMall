package com.nwafu.catmall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwafu.catmall.common.utils.PageUtils;
import com.nwafu.catmall.common.utils.Query;
import com.nwafu.catmall.order.dao.PaymentInfoDao;
import com.nwafu.catmall.order.entity.PaymentInfoEntity;
import com.nwafu.catmall.order.service.PaymentInfoService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("paymentInfoService")
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoDao, PaymentInfoEntity> implements PaymentInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PaymentInfoEntity> page = this.page(
                new Query<PaymentInfoEntity>().getPage(params),
                new QueryWrapper<PaymentInfoEntity>()
        );

        return new PageUtils(page);
    }

}
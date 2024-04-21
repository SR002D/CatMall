package com.nwafu.catmall.coupon.service.impl;

import com.nwafu.catmall.coupon.entity.MemberPriceEntity;
import com.nwafu.catmall.coupon.entity.SkuLadderEntity;
import com.nwafu.catmall.coupon.service.MemberPriceService;
import com.nwafu.catmall.coupon.service.SkuLadderService;
import com.nwafu.catmall.common.to.MemberPrice;
import com.nwafu.catmall.common.to.SkuReductionTo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwafu.catmall.common.utils.PageUtils;
import com.nwafu.catmall.common.utils.Query;

import com.nwafu.catmall.coupon.dao.SkuFullReductionDao;
import com.nwafu.catmall.coupon.entity.SkuFullReductionEntity;
import com.nwafu.catmall.coupon.service.SkuFullReductionService;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Autowired
    SkuLadderService skuLadderService;

    @Autowired
    MemberPriceService memberPriceService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionTo to) {
        // 1.保存满减打折，会员价
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        skuLadderEntity.setSkuId(to.getSkuId());
        skuLadderEntity.setFullCount(to.getFullCount());
        skuLadderEntity.setDiscount(to.getDiscount());
        skuLadderEntity.setAddOther(to.getCountStatus());
//        skuLadderEntity.setPrice();

        if(to.getFullCount()>0){
            skuLadderService.save(skuLadderEntity);
        }



        // 2.满减信息
        SkuFullReductionEntity reductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(to,reductionEntity);
        if(to.getFullPrice().compareTo(new BigDecimal("0"))==1){
            this.save(reductionEntity);
        }


        // 3.会员价格
        List<MemberPrice> memberPrice = to.getMemberPrice();
        List<MemberPriceEntity> collect = memberPrice.stream().map(item -> {
            MemberPriceEntity priceEntity = new MemberPriceEntity();
            priceEntity.setSkuId(to.getSkuId());
            priceEntity.setMemberLevelId(to.getSkuId());
            priceEntity.setMemberLevelName(item.getName());
            priceEntity.setMemberPrice(item.getPrice());
            priceEntity.setAddOther(1);
            return priceEntity;
        }).filter(item->{
            return item.getMemberPrice().compareTo(new BigDecimal("0"))==1;
        }).collect(Collectors.toList());

        memberPriceService.saveBatch(collect);
    }

}
package com.nwafu.catmall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwafu.catmall.common.utils.PageUtils;
import com.nwafu.catmall.common.utils.Query;
import com.nwafu.catmall.member.dao.MemberStatisticsInfoDao;
import com.nwafu.catmall.member.entity.MemberStatisticsInfoEntity;
import com.nwafu.catmall.member.service.MemberStatisticsInfoService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("memberStatisticsInfoService")
public class MemberStatisticsInfoServiceImpl extends ServiceImpl<MemberStatisticsInfoDao, MemberStatisticsInfoEntity> implements MemberStatisticsInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberStatisticsInfoEntity> page = this.page(
                new Query<MemberStatisticsInfoEntity>().getPage(params),
                new QueryWrapper<MemberStatisticsInfoEntity>()
        );

        return new PageUtils(page);
    }

}
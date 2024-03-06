package com.nwafu.catmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwafu.common.utils.PageUtils;
import com.nwafu.catmall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 10:53:19
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


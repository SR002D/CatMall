package com.nwafu.catmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwafu.common.utils.PageUtils;
import com.nwafu.catmall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 10:58:25
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


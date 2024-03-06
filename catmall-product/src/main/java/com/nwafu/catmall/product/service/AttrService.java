package com.nwafu.catmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwafu.common.utils.PageUtils;
import com.nwafu.catmall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 10:58:25
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


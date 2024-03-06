package com.nwafu.catmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwafu.common.utils.PageUtils;
import com.nwafu.catmall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 10:33:18
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package com.nwafu.catmall.product.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.nwafu.catmall.product.entity.SpuInfoDescEntity;
import com.nwafu.catmall.product.service.SpuInfoDescService;
import com.nwafu.common.utils.R;



/**
 * spu信息介绍
 *
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-02-08 16:05:23
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {
    @Autowired
    private SpuInfoDescService spuInfoDescService;

    /**
      * 列表
      */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuinfodesc:list")
    public R list(@RequestParam Map<String, Object> params){
        // 此处暂时不加条件, 但生产环境必须根据需求加
        IPage<SpuInfoDescEntity> result=spuInfoDescService.lambdaQuery()
                .page(new Page<>(Long.parseLong(params.get("currentPage").toString()),Long.parseLong(params.get("pageSize").toString())));

        return R.ok().put("page", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{spuId}")
    // @RequiresPermissions("product:spuinfodesc:info")
    public R info(@PathVariable("spuId") Long spuId){
		SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);

        return R.ok().put("spuInfoDesc", spuInfoDesc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:spuinfodesc:save")
    public R save(@RequestBody SpuInfoDescEntity spuInfoDesc){
		spuInfoDescService.save(spuInfoDesc);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:spuinfodesc:update")
    public R update(@RequestBody SpuInfoDescEntity spuInfoDesc){
		spuInfoDescService.updateById(spuInfoDesc);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:spuinfodesc:delete")
    public R delete(@RequestBody Long[] spuIds){
		spuInfoDescService.removeByIds(Arrays.asList(spuIds));

        return R.ok();
    }

}

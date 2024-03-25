package com.nwafu.catmall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.nwafu.catmall.product.entity.ProductAttrValueEntity;
import com.nwafu.catmall.product.service.ProductAttrValueService;
import com.nwafu.catmall.product.vo.AttrRespVo;
import com.nwafu.catmall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nwafu.catmall.product.service.AttrService;
import com.nwafu.common.utils.PageUtils;
import com.nwafu.common.utils.R;



/**
 * 商品属性
 *
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-03-06 10:58:25
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseQueryList(@RequestParam Map<String, Object> params,
                          @PathVariable("catelogId") Long catelogId,
                           @PathVariable("attrType")String type){
        PageUtils page =attrService.queryBaseAttrPage(params,catelogId,type);
        return R.ok().put("page", page);
    }

    @GetMapping("/base/listforspu/{spuId}")
    public R baseAttrListforspu(@PathVariable("spuId") Long spuId){
        List<ProductAttrValueEntity> entites = productAttrValueService.baseAttrListforspu(spuId);
        return R.ok().put("data",entites);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
        AttrRespVo attr = attrService.getAttrInfo(attrId);


        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttr(attr);

        return R.ok();
    }

    @PostMapping("/update/{spuId}")
    public R updateSpuAttr(@PathVariable("spuId") Long spuId,
                     @RequestBody List<ProductAttrValueEntity> entities){
        productAttrValueService.updateSpuAttr(spuId,entities);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}

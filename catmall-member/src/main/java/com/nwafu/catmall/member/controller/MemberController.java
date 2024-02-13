package com.nwafu.catmall.member.controller;

import java.util.Arrays;
import java.util.Map;


import com.nwafu.catmall.member.feign.MemberCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.nwafu.catmall.member.entity.MemberEntity;
import com.nwafu.catmall.member.service.MemberService;
import com.nwafu.common.utils.R;



/**
 * 会员
 *
 * @author sr
 * @email 610311761@qq.com
 * @date 2024-02-08 21:58:22
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberCouponService memberCouponService;

    @RequestMapping("test")
    public R test(){
        MemberEntity member = new MemberEntity();
        member.setNickname("张三");

       R memberCoupon = memberCouponService.memberCoupon();
       return R.ok().put("member",member).put("coupon",memberCoupon.get("coupon"));

    }

    /**
      * 列表
      */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        // 此处暂时不加条件, 但生产环境必须根据需求加
        IPage<MemberEntity> result=memberService.lambdaQuery()
                .page(new Page<>(Long.parseLong(params.get("currentPage").toString()),Long.parseLong(params.get("pageSize").toString())));

        return R.ok().put("page", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

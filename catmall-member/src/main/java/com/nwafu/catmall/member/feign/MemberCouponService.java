package com.nwafu.catmall.member.feign;

import com.nwafu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient("catmall-coupon")
public interface MemberCouponService {

    @RequestMapping("/coupon/coupon/member/list")
    R memberCoupon();
}

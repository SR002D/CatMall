package com.nwafu.catmall.product.fallback;

import com.nwafu.catmall.common.exception.BizCodeEnum;
import com.nwafu.catmall.common.utils.R;
import com.nwafu.catmall.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;


@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMessage());
    }
}

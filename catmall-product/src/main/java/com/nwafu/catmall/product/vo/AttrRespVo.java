package com.nwafu.catmall.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AttrRespVo extends AttrVo{

    private String catelogName;
    private String groupName;


    private Long[] catelogPath;
}

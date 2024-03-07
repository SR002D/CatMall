package com.nwafu.common.exception;

import lombok.Getter;

/**
 *
 */
public enum BizCodeEnum {
    UNKNOW_EXEPTION(10000,"系统未知异常"),
    VALID_EXCEPTION(10001,"参数格式校验异常");

    @Getter
    private int code;
    @Getter
    private String msg;

    BizCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

}

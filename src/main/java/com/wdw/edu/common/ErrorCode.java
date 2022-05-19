package com.wdw.edu.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS(20000, "ok"),
    PARAMS_ERROR(40000, "请求参数错误"),
    SYSTEM_ERROR(50000, "系统内部异常");

    private Integer code;

    private String message;

}

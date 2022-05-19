package com.wdw.edu.common;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final Integer code;

    private final String message;

    public BaseException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}

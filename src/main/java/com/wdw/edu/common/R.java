package com.wdw.edu.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    private R() {
    }

    public static R ok() {
        R r = new R();
        r.setCode(ErrorCode.SUCCESS.getCode());
        r.setMessage(ErrorCode.SUCCESS.getMessage());
        return r;
    }

    public static R error() {
        R r = new R();
        r.setCode(ErrorCode.SYSTEM_ERROR.getCode());
        r.setMessage(ErrorCode.SYSTEM_ERROR.getMessage());
        return r;
    }

    public static R error(String message) {
        R r = new R();
        r.setCode(ErrorCode.SYSTEM_ERROR.getCode());
        r.setMessage(message);
        return r;
    }

    public static R error(ErrorCode ErrorCode) {
        R r = new R();
        r.setCode(ErrorCode.getCode());
        r.setMessage(ErrorCode.getMessage());
        return r;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}

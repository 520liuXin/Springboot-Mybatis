package com.example.demo.enums;


/**
 * Created by Tiger on 2018/10/9.
 */
public enum  ErrorCodeAndMsg {


    SUCCESS("00000","请求成功"),
    USER_FAIL("00001","已存在，请登录"),

    ;

    private String code;
    private String msg;

    ErrorCodeAndMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
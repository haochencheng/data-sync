package pers.doc.sync.common;

import java.io.Serializable;

/**
 * 统一返回结果类
 */
public class ReturnResult<T> implements Serializable {

    private int status;    //状态码

    private String msg;   //描述

    private T data; //数据结果集

    public ReturnResult(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ReturnResult ok(){
        return new ReturnResult(ErrorCodeConstant.SUCCESS_CODE);
    }
    public static ReturnResult error(){
        return new ReturnResult(ErrorCodeConstant.ERROR_CODE);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ReturnResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ReturnResult(int status) {
        this.status = status;
    }


}

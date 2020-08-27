package com.newoxen.springcloud.tbms.admin.util;

/**
 * 昆明鑫牛科技 (C) 2015
 * 通用JSON返回包
 * @author gaowei
 */

public class ResponseEntity<T> {
    private int code; //0-正常；非零异常
    private String msg;
    private T data; //返回数据
    private int count; //For layui 列表

    public ResponseEntity(){
        this.code = 0;
        this.msg = "";
        this.data = null;
    }
    public ResponseEntity(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

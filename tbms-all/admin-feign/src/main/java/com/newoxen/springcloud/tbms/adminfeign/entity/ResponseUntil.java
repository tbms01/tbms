package com.newoxen.springcloud.tbms.adminfeign.entity;

/**
 * 昆明鑫牛科技 (C) 2015
 * 通用JSON打包工具类
 * @author gaowei
 */


public class ResponseUntil {

    public final static int RET_OK = 0;
    public final static int RET_ERR = -1;


    /**
     * 操作成功
     */
    public static<T> ResponseEntity<T> retOK(T data){
        return new ResponseEntity<T>(RET_OK, "操作成功", data);
    }

    public static<T> ResponseEntity<T> retOK(T data, String message){
        return new ResponseEntity<T>(RET_OK, message, data);
    }


    /**
     * 操作失败
     */
    public static<T> ResponseEntity<T> retErr(String message){
        return new ResponseEntity<T>(RET_ERR, message, null);
    }
    public static<T> ResponseEntity<T> retErr(String message, T data){
        return new ResponseEntity<T>(RET_ERR, message, data);
    }
    public static<T> ResponseEntity<T> retErr(int err_code, String message,T data){
        return new ResponseEntity<T>(err_code!=0?err_code:RET_ERR, message, data);
    }
}

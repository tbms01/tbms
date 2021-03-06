package com.newoxen.springcloud.tbms.admin.util;

/**
 * 昆明鑫牛科技 (C) 2015
 * 通用JSON打包工具类
 * @author gaowei
 */


public class ResponseUtil {

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

    public static ResponseEntity<String> retOK(String message){
        return new ResponseEntity<String>(RET_OK, message, null);
    }


    /**
     * 操作失败
     */
    public static<T> ResponseEntity<T> retErr(String message){
        return new ResponseEntity<T>(RET_ERR, message, null);
    }
    public static<T> ResponseEntity<T> retErr(Exception ex){
        return new ResponseEntity<T>(RET_ERR, ex.getLocalizedMessage(), null);
    }
    public static<T> ResponseEntity<T> retErr(int err_code, String message,T data){
        return new ResponseEntity<T>(err_code!=0?err_code:RET_ERR, message, data);
    }
}

package com.zuoer.common;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private boolean success;
    private String msg;
    private T data;

    public Result(){
        this.success = true;
    }

    public Result(boolean success, T data){
        this.success = success;
        this.data = data;
        if(!success){
            this.msg = data.toString();
        }
    }

    public Result(boolean success, String msg, T data){
        this.success = success;
        this.data = data;
        this.msg = msg;
    }


    public boolean isSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
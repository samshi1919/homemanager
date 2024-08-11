package com.zuoer.common.base;

import com.zuoer.common.AppErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ck
 * @date 2022/5/23 15:35
 */
@Data
@ApiModel("ResponseResult")
public class ResponseData<T> {
    /**
     * 统一返回码
     */
    @ApiModelProperty("返回码")
    public Integer rtnCode;

    /**
     * 统一错误消息
     */
    @ApiModelProperty("返回码消息")
    public String rtnMsg;

    /**
     * 结果对象
     */
    @ApiModelProperty("返回数据内容")
    public T rtnData;




    public ResponseData(Integer rtnCode, String rtnMsg) {
        this.rtnCode = rtnCode;
        this.rtnMsg = rtnMsg;
    }


    public ResponseData(Integer rtnCode, String rtnMsg, T rtnData) {
        this.rtnCode = rtnCode;
        this.rtnMsg = rtnMsg;
        this.rtnData = rtnData;
    }


    public static <T> ResponseData success() {
        return new ResponseData(AppErrorCode.SUCCESS.getCode(), AppErrorCode.SUCCESS.getDesc());
    }

    public static <T> ResponseData success(boolean result) {

        return new ResponseData(AppErrorCode.SUCCESS.getCode(), AppErrorCode.SUCCESS.getDesc(), result);

    }

    public static <T> ResponseData success(T rtnData) {
        return new ResponseData(AppErrorCode.SUCCESS.getCode(), AppErrorCode.SUCCESS.getDesc(), rtnData);
    }

    public static <T> ResponseData success(boolean needEncrypt, T rtnData) {
        return new ResponseData(AppErrorCode.SUCCESS.getCode(), AppErrorCode.SUCCESS.getDesc(), rtnData);
    }

    public static <T> ResponseData failure(Integer code, String desc) {
        return new ResponseData(code, desc);
    }


    public static <T> ResponseData failure(Integer code, String desc, String rtnDetailMsg) {
        return new ResponseData(code, desc, rtnDetailMsg);
    }

    public static <T> ResponseData systemError() {
        return new ResponseData(AppErrorCode.SYSTEM_ERROR.getCode(), AppErrorCode.SYSTEM_ERROR.getDesc(), false);
    }
}
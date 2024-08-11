package com.zuoer.common;

/**
 * @author ck
 * @date 2022/6/14 15:42
 * @desc 自定义异常
 */
public class BusinessException extends RuntimeException {

    private AppErrorCode exceptionEnum;
    private Integer code;
    private String errorMsg;

    public BusinessException() {
        super();
    }

    public BusinessException(AppErrorCode exceptionEnum) {
        super("{code:" + exceptionEnum.getCode() + ",errorMsg:" + exceptionEnum.getDesc() + "}");
        this.exceptionEnum = exceptionEnum;
        this.code = exceptionEnum.getCode();
        this.errorMsg = exceptionEnum.getDesc();
    }

    public BusinessException(Integer code, String errorMsg) {
        super("{code:" + code + ",errorMsg:" + errorMsg + "}");
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public BusinessException(Integer code, String errorMsg, Object... args) {
        super("{code:" + code + ",errorMsg:" + String.format(errorMsg, args) + "}");
        this.code = code;
        this.errorMsg = String.format(errorMsg, args);
    }

    public AppErrorCode getExceptionEnum() {
        return exceptionEnum;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

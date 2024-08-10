package com.zuoer.config;

import com.alibaba.fastjson.JSON;
import com.zuoer.common.AppErrorCode;
import com.zuoer.common.BusinessException;
import com.zuoer.common.base.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ck
 * @date 2022/6/14 15:44
 * @desc 统一异常处理
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerConfig {

    @Autowired
    private Environment env;

    /**
     * 业务异常处理
     *
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseData exceptionHandler(BusinessException e) {
        log.error(e.getErrorMsg(), e);
        return ResponseData.failure(e.getCode(), e.getErrorMsg());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseData exception(MethodArgumentNotValidException e, HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        log.error("请求[ {} ] {} 的参数校验发生错误", request.getMethod(), request.getRequestURL());
        for (ObjectError objectError : bindingResult.getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            log.error("参数 {} = {} 校验错误：{}", fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
            result.put(fieldError.getField(), fieldError.getDefaultMessage());

        }
        return ResponseData.failure(AppErrorCode.PARAM_ERROR.getCode(),
                JSON.toJSONString(result));
    }


    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public ResponseData maxSizeExceptionHandler(MaxUploadSizeExceededException e) {
        log.error(e.getMessage(), e);
        return ResponseData.failure(AppErrorCode.FILE_SIZE_EXCEEDED.getCode(),AppErrorCode.FILE_SIZE_EXCEEDED.getDesc());
    }

    /**
     * 未知异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData exceptionHandler(Exception e) {
        log.error("出现系统异常", e);
        String errorMsg = null;
        String[] activeProfiles = env.getActiveProfiles();
        //开发环境返回具体的报错信息,前端需要处理不要返回具体得报错信息
        if (null != activeProfiles) {
            if (activeProfiles[0].equals("dev")) {
                errorMsg = StringUtils.substring(e.getMessage(), 0, 2000);
            }
        }
        return ResponseData.failure(AppErrorCode.SYSTEM_ERROR.getCode(),
                errorMsg);

    }


}
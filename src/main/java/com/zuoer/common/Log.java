package com.zuoer.common;

import java.lang.annotation.*;

/**
 * @author ck
 * @date 2023/7/18 14:46
 * @desc
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String module() default "";

    /**
     * 功能
     */
    public String function() default "";

}

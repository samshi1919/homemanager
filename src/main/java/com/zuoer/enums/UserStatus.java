package com.zuoer.enums;

public enum UserStatus {

    AUDIT(0, "审核中"),

    NORMAL(1, "正常"),

    DISABLED(2, "禁用"),

    ;


    private Integer code;
    private String desc;

    UserStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

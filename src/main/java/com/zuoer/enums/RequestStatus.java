package com.zuoer.enums;

public enum RequestStatus {

    PROGRESS(0, "申请中"),

    APPROVED(1, "通过"),

    REJECTION(2, "拒绝"),

    ;


    private Integer code;
    private String desc;

    RequestStatus(Integer code, String desc) {
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

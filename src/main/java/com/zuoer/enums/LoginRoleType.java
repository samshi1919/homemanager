package com.zuoer.enums;

public enum LoginRoleType {

    OWNER("owner", "业主"),

    HOUSEKEEPER("housekeeper", "管家"),

    ADMIN("admin", "管理员"),

    ;


    private String code;
    private String desc;

    LoginRoleType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

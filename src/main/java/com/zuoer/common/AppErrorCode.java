package com.zuoer.common;


/**
 * @author ck
 * @date 2022/5/23 15:40
 * @desc 错误码
 */
public enum AppErrorCode {
    SUCCESS(10000, "success"),
    TOKEN_EXPIRED(10001, "token  expire"),
    TOKEN_ILLEGAL(10002, "Illegal token"),
    TOKEN_MISSING(10003, "missing token"),

    USER_EXIST(10004, "user exist"),
    USER_ROLE_ASSIGNED(10005, "The user has been assigned a role and failed to be deleted"),
    ROLE_PERMISSION_ASSIGNED(10006, "Failed to delete a role because it has been assigned rights"),
    USER_NOT_EXIST(10007, "user does not exist"),
    NAME_EXIST(10008, "name exists"),

    OBJECT_NOT_EXIST(10009, "object not exists"),

    FILE_NAME_TOO_LONG(10010, "file name too long"),

    FILE_UPLOAD_ERROR(10011, "file upload error"),

    OBJECT_SAVE_ERROR(99995, "object save error"),
    OBJECT_UPDATE_ERROR(99996, "object update error"),
    OBJECT_DELETE_ERROR(99997, "object delete error"),
    PARAM_ERROR(99998, "parameter exception"),
    DEPT_ERROR(99998, "department has existed"),
    DEPT_SAME_ERROR(99998, "the higher-level department cannot be itself"),
    DEPT_CHILD_ERROR(99998, "the department contains sub-departments that are not retired"),
    DEPT_DELETE_CHILD_ERROR(99998, "There are subdivisions in this department and cannot be deleted"),
    DEPT_DELETE_USER_ERROR(99998, "the department has users and cannot be deleted"),
    SYSTEM_ERROR(99999, "system exception"),

    //业务异常码
    LABEL_NAME_EXIST(50001, "label name exist"),

    QUESTION_NOT_EXIST(50002, "question not exist"),

    QUESTION_AUTH_ERROR(50003, "question auth error"),

    QUESTION_STATUS_ERROR(50004, "question status error"),

    QUESTION_ADDITIONAL_INFO_EXIST(50004, "question additional info exist"),


    INVALID_FILE_TYPE(50005, "invalid file type"),

    FILE_SIZE_EXCEEDED(50006, "file size exceeded, max size 50M"),


    QUESTION_HAS_BEEN_ACCEPTED(50007, "question has been accepted"),

    TRANSLATE_ERROR(50008, "translate error"),

    ;




    private String desc;
    private Integer code;

    private AppErrorCode(Integer code, String msg) {
        this.code = code;
        this.desc = msg;
    }

    public String getDesc() {
        return this.desc;
    }

    public Integer getCode() {
        return this.code;
    }
}

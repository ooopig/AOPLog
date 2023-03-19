package com.example.aoplog.constant;

/**
 * @author wangzhenjun
 * @date 2022/10/26 11:22
 */
public enum BusinessTypeEnum {

    /**
     * 其它
     */
    OTHER(0,"其它"),

    /**
     * 新增
     */
    INSERT(1,"新增"),

    /**
     * 修改
     */
    UPDATE(2,"修改"),

    /**
     * 删除
     */
    DELETE(3,"删除");

    private Integer code;

    private String message;

    BusinessTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}


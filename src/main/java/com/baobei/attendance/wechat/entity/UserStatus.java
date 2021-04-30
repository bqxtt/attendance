package com.baobei.attendance.wechat.entity;

/**
 * @author tcg
 * @date 2021/4/14
 */
public enum UserStatus {
    UNBIND(0),
    STUDENT(1),
    TEACHER(2);

    private Integer code;

    UserStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}

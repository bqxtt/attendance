package com.baobei.attendance.wechat.entity;

import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
public class StudentAuth {
    private String openId;
    private String stuNo;
    private String username;
}

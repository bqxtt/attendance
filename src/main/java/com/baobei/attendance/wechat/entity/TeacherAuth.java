package com.baobei.attendance.wechat.entity;

import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
public class TeacherAuth {
    private String openId;
    private String username;
    private String password;
}

package com.baobei.attendance.wechat.entity;

import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/19
 */
@Data
public class StudentInfo {
    private Long id;
    private String phone;
    private String urgentPhone;
    private String address;
}

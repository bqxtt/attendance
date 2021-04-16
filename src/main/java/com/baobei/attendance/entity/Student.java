package com.baobei.attendance.entity;

import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
public class Student {
    private Long id;
    private String stuNo;
    private String username;
    private Long classId;
    private Long majorId;
    private Long departmentId;
    private Long dormitoryId;
    private String phone;
    private String urgentPhone;
    private Integer role;
    private Integer sex;
    private String address;
}

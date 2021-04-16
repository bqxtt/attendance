package com.baobei.attendance.web.entity;

import com.baobei.attendance.entity.Class;
import lombok.Data;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
public class WebUser {
    private Long id;
    private String teacherNo;
    private String account;
    private String password;
    private String phone;
    private List<Long> classIds;
    private List<Class> classes;
}

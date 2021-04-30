package com.baobei.attendance.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
@ApiModel
public class Class {
    private Long id;
    private String departmentName;
    private String majorName;
    private String classNo;
    private String className;

    public String getClassName() {
        return this.majorName + this.classNo;
    }
}

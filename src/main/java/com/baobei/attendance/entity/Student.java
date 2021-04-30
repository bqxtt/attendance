package com.baobei.attendance.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
@ApiModel
public class Student {
    private Long id;
    private String stuNo;
    private String username;
    private Long classId;
    @ApiModelProperty(hidden = true)
    private Class aClass;
    @ApiModelProperty(hidden = true)
    private String departmentName;
    @ApiModelProperty(hidden = true)
    private String majorName;
    private Long dormitoryId;
    @ApiModelProperty(hidden = true)
    private Dormitory dormitory;
    private String phone;
    private String urgentPhone;
    private Integer role;
    private Integer sex;
    private String address;
    private String faceUrl;
}

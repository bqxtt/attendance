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
public class Class {
    private Long id;
    private Long departmentId;
    private Long majorId;
    private String classNo;
    private String className;
    @ApiModelProperty(hidden = true)
    private Department department;
    @ApiModelProperty(hidden = true)
    private Major major;
}

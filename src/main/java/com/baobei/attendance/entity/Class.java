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
    @ApiModelProperty(hidden = true)
    private Long id;
    private Long majorId;
    private String classNo;
    private String className;
}

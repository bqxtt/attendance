package com.baobei.attendance.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
@ApiModel
public class Department {
    private Long id;
    private String departmentNo;
    private String departmentName;
    @ApiModelProperty(hidden = true)
    private List<Major> majors;
}

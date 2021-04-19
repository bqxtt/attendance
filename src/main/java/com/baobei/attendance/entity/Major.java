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
public class Major {
    private Long id;
    private Long departmentId;
    private String majorNo;
    private String majorName;
    @ApiModelProperty(hidden = true)
    private List<Class> classes;
}

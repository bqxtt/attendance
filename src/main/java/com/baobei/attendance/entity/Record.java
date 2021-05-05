package com.baobei.attendance.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author tcg
 * @date 2021/4/18
 */
@ApiModel
@Data
public class Record {
    @ApiModelProperty(hidden = true)
    private Long id;
    private Long studentId;
    private String studentNo;
    private String username;
    private Long classId;
    @ApiModelProperty(hidden = true)
    private Date recordTime;
    private String photoUrl;
}

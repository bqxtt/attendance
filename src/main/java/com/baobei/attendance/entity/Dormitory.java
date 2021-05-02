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
public class Dormitory {
    private Long id;
    private String community;
    private String building;
    private String roomNo;
    private String roomName;
    private Integer capacity;
    @ApiModelProperty(hidden = true)
    private List<Student> students;

    public String getRoomName() {
        return community + "#" + building + roomNo;
    }
}

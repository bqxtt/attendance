package com.baobei.attendance.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
@ApiModel
public class Department {
    private String departmentName;
    private List<Major> majors;
}

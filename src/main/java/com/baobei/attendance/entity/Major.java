package com.baobei.attendance.entity;

import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
public class Major {
    private Long id;
    private Long departmentId;
    private String majorNo;
    private String majorName;
}

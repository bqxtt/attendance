package com.baobei.attendance.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author tcg
 * @date 2021/4/18
 */
@Data
public class Record {
    private Long id;
    private Long studentId;
    private String studentNo;
    private String username;
    private Long classId;
    private Date recordTime;
    private String photoUrl;
}

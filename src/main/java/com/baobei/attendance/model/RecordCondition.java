package com.baobei.attendance.model;

import lombok.Data;

import java.util.Date;

@Data
public class RecordCondition {
    private Long studentId;
    private String studentNo;
    private Long classId;
    private Date startTime;
    private Date endTime;
}

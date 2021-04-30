package com.baobei.attendance.web.entity;

import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Data
public class Face {
    private Long id;
    private Long studentId;
    private String studentNo;
    private String faceToken;
    private String url;
}

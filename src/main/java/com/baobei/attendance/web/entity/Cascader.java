package com.baobei.attendance.web.entity;

import lombok.Data;

import java.util.List;

@Data
public class Cascader {
    private String label;
    private String value;
    private List<Cascader> children;
}

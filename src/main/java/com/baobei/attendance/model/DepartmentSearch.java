package com.baobei.attendance.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DepartmentSearch extends Search {
    private Long id;
    private String departmentName;

    @Override
    public void normalize() {
        super.normalize();
        if (id == 0) {
            id = null;
        }
        if ("".equals(departmentName)) {
            departmentName = null;
        }
    }
}

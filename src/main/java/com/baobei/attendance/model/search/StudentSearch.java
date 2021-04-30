package com.baobei.attendance.model.search;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author tcg
 * @date 2021/4/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StudentSearch extends Search {
    private Long id;
    private String studentNo;
    private String username;
    private String departmentName;
    private String majorName;

    @Override
    public void normalize() {
        super.normalize();
        if (id == null || id == 0) {
            id = null;
        }
        if ("".equals(studentNo)) {
            studentNo = null;
        }
        if ("".equals(username)) {
            username = null;
        }
        if ("".equals(departmentName)) {
            departmentName = null;
        }
        if ("".equals(majorName)) {
            majorName = null;
        }
    }

    //todo
}

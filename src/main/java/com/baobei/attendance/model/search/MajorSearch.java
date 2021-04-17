package com.baobei.attendance.model.search;

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
public class MajorSearch extends Search {
    private Long id;
    private Long departmentId;
    private String majorName;

    @Override
    public void normalize() {
        super.normalize();
        if (id == null || id == 0) {
            id = null;
        }
        if (departmentId == 0) {
            departmentId = null;
        }
        if ("".equals(majorName)) {
            majorName = null;
        }
    }

}

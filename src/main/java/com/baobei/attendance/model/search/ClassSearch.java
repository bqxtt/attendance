package com.baobei.attendance.model.search;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author tcg
 * @date 2021/4/17
 */
@ApiModel
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClassSearch extends Search {
    private Long id;
    private String className;
    private String departmentName;
    private String majorName;

    @Override
    public void normalize() {
        super.normalize();
        if ("".equals(departmentName)) {
            departmentName = null;
        }
        if ("".equals(majorName)) {
            majorName = null;
        }
        if ("".equals(className)) {
            className = null;
        }
        if (id == null || id == 0) {
            id = null;
        }
    }

}

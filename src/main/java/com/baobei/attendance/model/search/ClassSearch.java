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
public class ClassSearch extends Search {
    private Long id;
    private Long majorId;
    private String className;

    @Override
    public void normalize() {
        super.normalize();
        if (majorId == 0) {
            majorId = null;
        }
        if ("".equals(className)) {
            className = null;
        }
        if (id == null || id == 0) {
            id = null;
        }
    }

}
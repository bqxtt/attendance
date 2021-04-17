package com.baobei.attendance.web.entity;

import com.baobei.attendance.model.search.Search;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WebUserSearch extends Search {
    private String teacherNo;
    private String account;

    @Override
    public void normalize() {
        super.normalize();
        if ("".equals(this.teacherNo)) {
            this.teacherNo = null;
        }
        if ("".equals(this.account)) {
            this.account = null;
        }
    }
}

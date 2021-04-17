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
public class DormitorySearch extends Search {
    private Long id;
    private String community;
    private String building;
    private String roomName;

    @Override
    public void normalize() {
        super.normalize();
        if (id == null || id == 0) {
            id = null;
        }
        if ("".equals(roomName)) {
            roomName = null;
        }
        if ("".equals(community)) {
            community = null;
        }
        if ("".equals(building)) {
            building = null;
        }
    }
}

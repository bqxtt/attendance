package com.baobei.attendance.model;

import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
public class PageInfo {
    private Integer totalPages;
    private Integer totalCount;

    public PageInfo(Integer totalPages, Integer totalCount) {
        this.totalPages = totalPages;
        this.totalCount = totalCount;
    }

    public static PageInfo getPageInfo(Integer totalCount, Integer pageSize) {
        return new PageInfo((totalCount + pageSize - 1) / pageSize, totalCount);
    }
}

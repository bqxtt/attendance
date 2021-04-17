package com.baobei.attendance.model.search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/15
 */
@Data
@ApiModel
public class Search {
    public static Integer defaultPageSize = 5;
    private Integer pageNo;
    private Integer pageSize;
    @ApiModelProperty(hidden = true)
    private Integer limit;
    @ApiModelProperty(hidden = true)
    private Integer offset;

    public Integer getLimit() {
        return this.pageSize;
    }

    public Integer getOffset() {
        return (this.pageNo - 1) * this.pageSize;
    }

    public void normalize() {
        if (this.pageNo < 1) {
            this.pageNo = 1;
        }
        if (this.pageSize < 1) {
            this.pageSize = defaultPageSize;
        }
    }

}

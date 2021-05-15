package com.baobei.attendance.model.search;

import com.baobei.attendance.utils.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author tcg
 * @date 2021/5/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel
public class RecordSearch extends Search {
    private String studentNo;
    private String username;
    @ApiModelProperty(hidden = true)
    private List<Long> studentIds;
    private List<Long> classIds;
    private List<Long> dormitoryIds;
    @ApiModelProperty(hidden = true)
    private Date startTime;
    @ApiModelProperty(hidden = true)
    private Date endTime;

    @Override
    public void normalize() {
        super.normalize();
        if ("".equals(studentNo)) {
            studentNo = null;
        }
        if ("".equals(username)) {
            username = null;
        }
        if (studentIds == null || studentIds.size() == 0) {
            studentIds = null;
        }
        if (classIds == null || classIds.size() == 0) {
            classIds = null;
        }
        if (dormitoryIds == null || dormitoryIds.size() == 0) {
            dormitoryIds = null;
        }
    }

    public void normalizeWithDate(int preDays) throws ParseException {
        normalize();
        this.startTime = DateUtil.getPreDaysStartEndDate(preDays).getStartTime();
        this.endTime = DateUtil.getPreDaysStartEndDate(0).getEndTime();
    }
}

package com.baobei.attendance.model;

import com.baobei.attendance.utils.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author 14861
 */
@Data
public class RecordCondition {
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

    public void normalize() {
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

package com.baobei.attendance.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tcg
 * @date 2021/4/18
 */
@ApiModel
@Data
public class Record {
    @ApiModelProperty(hidden = true)
    private Long id;
    private Long studentId;
    private String studentNo;
    private String username;
    private Long classId;
    private Long dormitoryId;
    @ApiModelProperty(hidden = true)
    private Date recordTime;
    private String recordTimeFormat;
    private String photoUrl;

    public String getRecordTimeFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (recordTime != null) {
            return formatter.format(recordTime);
        }
        return "";
    }
}

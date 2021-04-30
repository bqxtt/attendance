package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class BaseRes {
    @JSONField(name = "error_code")
    private Integer errorCode;
    @JSONField(name = "error_msg")
    private String errorMsg;
    @JSONField(name = "log_id")
    private Long logId;
    @JSONField(name = "timestamp")
    private Long timestamp;
    @JSONField(name = "cached")
    private Integer cached;

    private String rawRes;
}

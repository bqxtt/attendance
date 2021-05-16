package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author tcg
 * @date 2021/5/16
 */
@Data
public class Brief {
    @JSONField(name = "record_time")
    private String recordTime;
    @JSONField(name = "score")
    private Double score;
}

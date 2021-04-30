package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Location {
    @JSONField(name = "left")
    private Double left;
    @JSONField(name = "top")
    private Double top;
    @JSONField(name = "width")
    private Double width;
    @JSONField(name = "height")
    private Double height;
    @JSONField(name = "rotation")
    private Integer rotation;
}

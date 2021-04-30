package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupGetListReq extends BaseReq {
    @JSONField(name = "start")
    private Integer start;
    @JSONField(name = "length")
    private Integer length;
}

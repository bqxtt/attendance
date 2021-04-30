package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserAddRes extends BaseRes {
    @JSONField(name = "face_token")
    private String faceToken;
    @JSONField(name = "location")
    private Location location;
}

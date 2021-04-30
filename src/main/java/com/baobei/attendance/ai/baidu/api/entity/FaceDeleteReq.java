package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FaceDeleteReq extends BaseReq {
    @JSONField(name = "user_id")
    private String userId;
    @JSONField(name = "group_id")
    private String groupId;
    @JSONField(name = "face_token")
    private String faceToken;
}

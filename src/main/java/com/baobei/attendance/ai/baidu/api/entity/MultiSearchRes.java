package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MultiSearchRes extends BaseRes {
    @JSONField(name = "result")
    private Result result;

    @Data
    public static class Result {
        @JSONField(name = "face_num")
        private Integer faceNum;
        @JSONField(name = "face_list")
        private List<Face> faceList;
    }

    @Data
    public static class Face {
        @JSONField(name = "face_token")
        private String faceToken;
        @JSONField(name = "location")
        private Location location;
        @JSONField(name = "user_list")
        private List<User> userList;
    }

    @Data
    public static class User {
        @JSONField(name = "group_id")
        private String groupId;
        @JSONField(name = "user_id")
        private String userId;
        @JSONField(name = "user_info")
        private String userInfo;
        @JSONField(name = "score")
        private Double score;
    }

}

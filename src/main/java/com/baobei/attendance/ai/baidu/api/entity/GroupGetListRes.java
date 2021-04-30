package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupGetListRes extends BaseRes {
    @JSONField(name = "result")
    private Result result;

    @Data
    public static class Result {
        @JSONField(name = "group_id_list")
        private List<String> groupIdList;
    }
}

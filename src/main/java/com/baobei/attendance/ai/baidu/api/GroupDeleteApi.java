package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.baobei.attendance.ai.baidu.api.entity.BaseReq;
import com.baobei.attendance.ai.baidu.api.entity.BaseRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author 14861
 */
@Component
public class GroupDeleteApi extends Api<GroupDeleteApi.GroupDeleteReq, GroupDeleteApi.GroupDeleteRes> {

    public GroupDeleteApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/delete";
    }

    @Override
    public GroupDeleteRes request(GroupDeleteReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.postJson(url, req, headers);
        GroupDeleteRes res = JSON.parseObject(resStr, GroupDeleteRes.class);
        res.setRawRes(resStr);
        return res;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public static class GroupDeleteReq extends BaseReq {
        @JSONField(name = "group_id")
        private String groupId;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public static class GroupDeleteRes extends BaseRes {
    }
}

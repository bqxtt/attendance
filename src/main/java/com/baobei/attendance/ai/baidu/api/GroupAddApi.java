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
 * @author bqx
 */
@Component
public class GroupAddApi extends Api<GroupAddApi.GroupAddReq, GroupAddApi.GroupAddRes> {

    public GroupAddApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/add";
    }

    @Override
    public GroupAddRes request(GroupAddReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.postJson(url, req, headers);
        GroupAddRes res = JSON.parseObject(resStr, GroupAddRes.class);
        res.setRawRes(resStr);
        return res;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class GroupAddReq extends BaseReq {
        @JSONField(name = "group_id")
        private String groupId;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class GroupAddRes extends BaseRes {

    }
}

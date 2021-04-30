package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.ai.baidu.api.entity.GroupDeleteReq;
import com.baobei.attendance.ai.baidu.api.entity.GroupDeleteRes;
import org.springframework.stereotype.Component;

@Component
public class GroupDeleteApi extends Api<GroupDeleteReq, GroupDeleteRes> {

    public GroupDeleteApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/delete";
    }

    @Override
    public GroupDeleteRes request(GroupDeleteReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.post(url, req, headers);
        GroupDeleteRes res = JSON.parseObject(resStr, GroupDeleteRes.class);
        res.setRawRes(resStr);
        return res;
    }
}

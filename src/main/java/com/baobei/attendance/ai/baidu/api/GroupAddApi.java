package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.ai.baidu.api.entity.GroupAddReq;
import com.baobei.attendance.ai.baidu.api.entity.GroupAddRes;
import org.springframework.stereotype.Component;

/**
 * @author bqx
 */
@Component
public class GroupAddApi extends Api<GroupAddReq, GroupAddRes> {

    public GroupAddApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/add";
    }

    @Override
    public GroupAddRes request(GroupAddReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.post(url, req, headers);
        GroupAddRes res = JSON.parseObject(resStr, GroupAddRes.class);
        res.setRawRes(resStr);
        return res;
    }
}

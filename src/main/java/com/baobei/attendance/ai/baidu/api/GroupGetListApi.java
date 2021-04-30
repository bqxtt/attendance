package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.ai.baidu.api.entity.GroupGetListReq;
import com.baobei.attendance.ai.baidu.api.entity.GroupGetListRes;

/**
 * @author bqx
 */
public class GroupGetListApi extends Api<GroupGetListReq, GroupGetListRes> {

    public GroupGetListApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/getlist";
    }

    @Override
    public GroupGetListRes request(GroupGetListReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.post(url, req, headers);
        GroupGetListRes res = JSON.parseObject(resStr, GroupGetListRes.class);
        res.setRawRes(resStr);
        return res;
    }
}

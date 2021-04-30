package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.ai.baidu.api.entity.MultiSearchReq;
import com.baobei.attendance.ai.baidu.api.entity.MultiSearchRes;

/**
 * @author bqx
 */
public class MultiSearchApi extends Api<MultiSearchReq, MultiSearchRes> {

    public MultiSearchApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/multi-search";
    }

    @Override
    public MultiSearchRes request(MultiSearchReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.post(url, req, headers);
        MultiSearchRes res = JSON.parseObject(resStr, MultiSearchRes.class);
        res.setRawRes(resStr);
        return res;
    }
}

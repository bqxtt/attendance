package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.ai.baidu.api.entity.FaceDeleteReq;
import com.baobei.attendance.ai.baidu.api.entity.FaceDeleteRes;
import org.springframework.stereotype.Component;

@Component
public class FaceDeleteApi extends Api<FaceDeleteReq, FaceDeleteRes> {
    public FaceDeleteApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/delete";
    }

    @Override
    public FaceDeleteRes request(FaceDeleteReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.post(url, req, headers);
        FaceDeleteRes res = JSON.parseObject(resStr, FaceDeleteRes.class);
        res.setRawRes(resStr);
        return res;
    }
}

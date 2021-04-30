package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.ai.baidu.api.entity.UserAddReq;
import com.baobei.attendance.ai.baidu.api.entity.UserAddRes;
import org.springframework.stereotype.Component;

/**
 * @author bqx
 */
@Component
public class UserAddApi extends Api<UserAddReq, UserAddRes> {
    public UserAddApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
    }

    @Override
    public UserAddRes request(UserAddReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.post(url, req, headers);
        UserAddRes res = JSON.parseObject(resStr, UserAddRes.class);
        res.setRawRes(resStr);
        return res;
    }

}

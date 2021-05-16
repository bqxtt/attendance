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
public class FaceDeleteApi extends Api<FaceDeleteApi.FaceDeleteReq, FaceDeleteApi.FaceDeleteRes> {
    public FaceDeleteApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/delete";
    }

    @Override
    public FaceDeleteRes request(FaceDeleteReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.postJson(url, req, headers);
        FaceDeleteRes res = JSON.parseObject(resStr, FaceDeleteRes.class);
        res.setRawRes(resStr);
        return res;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public static class FaceDeleteReq extends BaseReq {
        @JSONField(name = "user_id")
        private String userId;
        @JSONField(name = "group_id")
        private String groupId;
        @JSONField(name = "face_token")
        private String faceToken;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class FaceDeleteRes extends BaseRes {
    }
}

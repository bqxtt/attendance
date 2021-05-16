package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.baobei.attendance.ai.baidu.api.entity.BaseReq;
import com.baobei.attendance.ai.baidu.api.entity.BaseRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author bqx
 */
@Component
public class GroupGetListApi extends Api<GroupGetListApi.GroupGetListReq, GroupGetListApi.GroupGetListRes> {

    public GroupGetListApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/getlist";
    }

    @Override
    public GroupGetListRes request(GroupGetListReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.postJson(url, req, headers);
        GroupGetListRes res = JSON.parseObject(resStr, GroupGetListRes.class);
        res.setRawRes(resStr);
        return res;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class GroupGetListReq extends BaseReq {
        @JSONField(name = "start")
        private Integer start;
        @JSONField(name = "length")
        private Integer length;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class GroupGetListRes extends BaseRes {
        @JSONField(name = "result")
        private Result result;

        @Data
        public static class Result {
            @JSONField(name = "group_id_list")
            private List<String> groupIdList;
        }
    }
}

package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroupGetListApiTest {

    @Test
    void request() throws Exception {
        GroupGetListApi api = new GroupGetListApi();
        GroupGetListApi.GroupGetListReq req = new GroupGetListApi.GroupGetListReq();
        System.out.println(JSON.toJSONString(req));
        GroupGetListApi.GroupGetListRes res = api.request(req);
        System.out.println(res);
    }
}
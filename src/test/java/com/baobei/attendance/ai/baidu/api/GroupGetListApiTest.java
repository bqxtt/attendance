package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.ai.baidu.api.entity.GroupGetListReq;
import com.baobei.attendance.ai.baidu.api.entity.GroupGetListRes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroupGetListApiTest {

    @Test
    void request() throws Exception {
        GroupGetListApi api = new GroupGetListApi();
        GroupGetListReq req = new GroupGetListReq();
        System.out.println(JSON.toJSONString(req));
        GroupGetListRes res = api.request(req);
        System.out.println(res);
    }
}
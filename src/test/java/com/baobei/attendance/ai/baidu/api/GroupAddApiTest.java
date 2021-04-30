package com.baobei.attendance.ai.baidu.api;

import com.baobei.attendance.ai.baidu.api.entity.GroupAddReq;
import com.baobei.attendance.ai.baidu.api.entity.GroupAddRes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroupAddApiTest {

    @Test
    void request() throws Exception {
        GroupAddApi api = new GroupAddApi();
        GroupAddReq req = new GroupAddReq();
        req.setGroupId("text_group");
        GroupAddRes res = api.request(req);
        System.out.println(res);
    }
}
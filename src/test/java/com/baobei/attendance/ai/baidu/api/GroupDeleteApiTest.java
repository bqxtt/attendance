package com.baobei.attendance.ai.baidu.api;

import com.baobei.attendance.ai.baidu.api.entity.BaseRes;
import com.baobei.attendance.ai.baidu.api.entity.GroupDeleteReq;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroupDeleteApiTest {

    @Test
    void request() throws Exception {
        GroupDeleteApi api = new GroupDeleteApi();
        GroupDeleteReq req = new GroupDeleteReq();
        req.setGroupId("text_group");
        BaseRes res = api.request(req);
        System.out.println(res);
    }
}
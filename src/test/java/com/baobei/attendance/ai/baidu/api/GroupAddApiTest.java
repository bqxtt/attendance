package com.baobei.attendance.ai.baidu.api;

import com.baobei.attendance.ai.baidu.api.entity.GroupAddReq;
import com.baobei.attendance.ai.baidu.api.entity.GroupAddRes;
import com.baobei.attendance.ai.baidu.factory.BaiduApiFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroupAddApiTest {

    @Autowired
    BaiduApiFactory baiduApiFactory;

    @Test
    void request() throws Exception {
        GroupAddApi api = baiduApiFactory.getGroupAddApi();
        GroupAddReq req = new GroupAddReq();
        req.setGroupId("hbgc_students");
        GroupAddRes res = api.request(req);
        System.out.println(res);
    }
}
package com.baobei.attendance.ai.baidu.api;

import com.baobei.attendance.ai.baidu.factory.BaiduApiFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tcg
 * @date 2021/5/16
 */
@SpringBootTest
class SamePicAddApiTest {
    @Autowired
    BaiduApiFactory baiduApiFactory;

    @Test
    void request() throws Exception {
        SamePicAddApi api = baiduApiFactory.getSamePicAddApi();
        SamePicAddApi.SamePicAddReq req = new SamePicAddApi.SamePicAddReq();
        Map<String, String> data = new HashMap<>();
        data.put("test", "test");
        req.setBrief("JSON.toJSONString(data)");
        req.setUrl("https://student-faces-repo.oss-cn-shanghai.aliyuncs.com/faces/170950212_1621096125038.png");
        System.out.println(req);
        SamePicAddApi.SamePicAddRes res = api.request(req);
        System.out.println(res);
    }
}
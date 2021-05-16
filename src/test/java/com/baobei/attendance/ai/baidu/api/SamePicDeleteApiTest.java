package com.baobei.attendance.ai.baidu.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tcg
 * @date 2021/5/16
 */
@SpringBootTest
class SamePicDeleteApiTest {

    @Autowired
    SamePicDeleteApi samePicDeleteApi;

    @Test
    void request() throws Exception {
        SamePicDeleteApi.SamePicDeleteReq req = new SamePicDeleteApi.SamePicDeleteReq();
        req.setUrl("https://student-faces-repo.oss-cn-shanghai.aliyuncs.com/faces/170950212_1621096125038.png");
        SamePicDeleteApi.SamePicDeleteRes res = samePicDeleteApi.request(req);
        System.out.println(res);
    }
}
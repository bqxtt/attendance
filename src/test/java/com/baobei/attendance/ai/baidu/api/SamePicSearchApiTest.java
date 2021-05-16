package com.baobei.attendance.ai.baidu.api;

import com.baobei.attendance.ai.baidu.factory.BaiduApiFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tcg
 * @date 2021/5/16
 */
@SpringBootTest
class SamePicSearchApiTest {

    @Autowired
    BaiduApiFactory baiduApiFactory;

    @Test
    void request() throws Exception {
        SamePicSearchApi api = baiduApiFactory.getSamePicSearchApi();
        SamePicSearchApi.SamePicSearchReq req = new SamePicSearchApi.SamePicSearchReq();
        req.setUrl("https://student-faces-repo.oss-cn-shanghai.aliyuncs.com/faces/170950212_1621097047450.jpg");
        SamePicSearchApi.SamePicSearchRes res = api.request(req);
        System.out.println(res);
    }
}
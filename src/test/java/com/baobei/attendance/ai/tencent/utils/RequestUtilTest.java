package com.baobei.attendance.ai.tencent.utils;

import com.baobei.attendance.config.bean.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RequestUtilTest {

 
    @Autowired
    Config config;

    @Test
    void post() throws Exception {
//        Map<String, Object> params = new HashMap<>();
//        params.put("app_id", config.getAIAppId());
//        params.put("time_stamp", new Date().getTime() / 1000);
//        params.put("nonce_str", Math.random());
//        requestUtil.post("https://api.ai.qq.com/fcgi-bin/face/face_getgroupids", params);
    }
}
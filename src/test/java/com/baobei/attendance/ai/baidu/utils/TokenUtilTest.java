package com.baobei.attendance.ai.baidu.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

@SpringBootTest
class TokenUtilTest {

    @Autowired
    TokenUtil tokenUtil;

    @Test
    void getToken() throws ExecutionException {
        System.out.println(tokenUtil.getToken());
    }
}
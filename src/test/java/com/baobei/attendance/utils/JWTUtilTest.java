package com.baobei.attendance.utils;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JWTUtilTest {

    @Test
    void generateToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("test", "test");
        String token = JWTUtil.generateToken(claims);
        System.out.println(token);
    }

    @Test
    void parseToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ0ZXN0IjoidGVzdCIsImV4cCI6MTYxOTk0Mjc3OCwiaWF0IjoxNjE5OTQyNDc4LCJqdGkiOiJlMWIzOWI4NC0xZDQ4LTQ4NmEtYjg5NC02YjZiM2U3ZDhkNmIifQ.BtPneURI6gyrSAbfB_fpvpI7OWyP7_1uMcdkytxIiHw";
        Claims claims = JWTUtil.parseToken(token);
        System.out.println(claims);
    }
}
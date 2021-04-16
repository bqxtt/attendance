package com.baobei.attendance.config.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author tcg
 * @date 2021/4/16
 */
@Data
public class Config {
    private String ossId;
    private String ossSecret;
    private String appId;
    private String appSecret;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void init() {
        ossId = redisTemplate.opsForValue().get("oss_id");
        ossSecret = redisTemplate.opsForValue().get("oss_secret");
        appId = redisTemplate.opsForValue().get("app_id");
        appSecret = redisTemplate.opsForValue().get("app_secret");
    }
}

package com.baobei.attendance.config.entity;

import com.baobei.attendance.config.ConfigMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

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
    private ConfigMapper configMapper;

    public void init() {
        ossId = configMapper.getConfig("oss_id");
        ossSecret = configMapper.getConfig("oss_secret");
        appId = configMapper.getConfig("app_id");
        appSecret = configMapper.getConfig("app_secret");
    }
}

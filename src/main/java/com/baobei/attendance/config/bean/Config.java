package com.baobei.attendance.config.bean;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.config.ConfigMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tcg
 * @date 2021/4/16
 */
@Data
public class Config {
    private OSSConfig ossConfig;
    private WeChatConfig weChatConfig;
    private BaiduAiConfig baiduAiConfig;


    @Autowired
    private ConfigMapper configMapper;

    public void init() {
        String config = configMapper.getConfig("oss_config");
        ossConfig = JSON.parseObject(config, OSSConfig.class);
        //System.out.println(ossConfig);

        config = configMapper.getConfig("wechat_config");
        weChatConfig = JSON.parseObject(config, WeChatConfig.class);
        //System.out.println(weChatConfig);

        config = configMapper.getConfig("baidu_ai_config");
        baiduAiConfig = JSON.parseObject(config, BaiduAiConfig.class);
        //System.out.println(baiduAiConfig);
    }
}

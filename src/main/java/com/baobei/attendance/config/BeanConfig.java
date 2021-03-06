package com.baobei.attendance.config;

import com.baobei.attendance.config.bean.Config;
import com.baobei.attendance.config.bean.OSSClient;
import com.baobei.attendance.config.bean.SpringContextUtil;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tcg
 * @date 2021/3/28
 */
@Configuration
public class BeanConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public OSSClient ossClient() {
        return new OSSClient();
    }

    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient();
    }

    @Bean(initMethod = "init")
    public Config config() {
        return new Config();
    }

    @Bean
    public SpringContextUtil springContextUtil() {
        return new SpringContextUtil();
    }
}

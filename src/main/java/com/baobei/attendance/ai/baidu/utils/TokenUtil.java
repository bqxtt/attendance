package com.baobei.attendance.ai.baidu.utils;

import com.baobei.attendance.config.bean.BaiduAiConfig;
import com.baobei.attendance.config.bean.Config;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author bqx
 */
@Component
public class TokenUtil {
    @Autowired
    HttpUtil httpUtil;
    @Autowired
    Config config;

    LoadingCache<String, String> tokenCache = CacheBuilder
            .newBuilder()
            .concurrencyLevel(8)
            .expireAfterWrite(20, TimeUnit.DAYS)
            .initialCapacity(10)
            .build(
                    new CacheLoader<String, String>() {
                        @Override
                        public String load(String key) throws Exception {
                            return loadToken();
                        }
                    }
            );

    public String getToken() throws ExecutionException {
        return tokenCache.get("token");
    }

    private String loadToken() throws Exception {
        BaiduAiConfig baiduAiConfig = config.getBaiduAiConfig();
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                + "grant_type=client_credentials"
                + "&client_id=" + baiduAiConfig.getApiKey()
                + "&client_secret=" + baiduAiConfig.getSecretKey();
        Map<String, Object> res = httpUtil.get(getAccessTokenUrl);
        return res.get("access_token").toString();
    }
}

package com.baobei.attendance.ai.baidu.utils;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.ai.baidu.api.entity.BaseReq;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class HttpUtil {
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    @Autowired
    OkHttpClient httpClient;

    public Map<String, Object> get(String url) throws Exception {
        Request request = new Request
                .Builder()
                .url(url)
                .get()
                .build();
        Call call = httpClient.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            String bodyStr = Objects.requireNonNull(response.body()).string();
            return JSON.parseObject(bodyStr);
        } else {
            throw new Exception("http util get failed");
        }
    }

    public String post(String url, BaseReq params, Map<String, Object> headers) throws Exception {
        RequestBody body = RequestBody.create(JSON.toJSONString(params), MEDIA_TYPE_JSON);
        Headers.Builder headersBuilder = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, Object> entry : headers.entrySet()) {
                headersBuilder.add(entry.getKey(), entry.getValue().toString());
            }
        }
        Headers headers1 = headersBuilder.build();
        Request request = new Request
                .Builder()
                .url(url)
                .headers(headers1)
                .post(body)
                .build();
        Call call = httpClient.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            return Objects.requireNonNull(response.body()).string();
        } else {
            throw new Exception("http util post failed");
        }
    }
}

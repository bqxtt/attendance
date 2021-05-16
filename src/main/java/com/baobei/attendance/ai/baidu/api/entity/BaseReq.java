package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author 14861
 */
public class BaseReq {
    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String toUrlString() {
        String jsonString = JSON.toJSONString(this);
        JSONObject json = JSON.parseObject(jsonString);
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            buffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }
}

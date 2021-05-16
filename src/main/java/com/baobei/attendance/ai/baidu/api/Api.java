package com.baobei.attendance.ai.baidu.api;

import com.baobei.attendance.ai.baidu.utils.HttpUtil;
import com.baobei.attendance.ai.baidu.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bqx
 */
public abstract class Api<RQ, RS> {

    @Autowired
    protected HttpUtil httpUtil;
    @Autowired
    protected TokenUtil tokenUtil;

    protected String baseUrl;
    protected final Map<String, Object> headers = new HashMap<>();

    public Api() {
        headers.put("Content-Type", "application/json");
    }

    protected String getUrlWithToken() throws Exception {
        return this.baseUrl + "?access_token=" + tokenUtil.getToken();
    }

    /**
     * 请求api
     *
     * @param req
     * @return
     * @throws Exception
     */
    public abstract RS request(RQ req) throws Exception;

}

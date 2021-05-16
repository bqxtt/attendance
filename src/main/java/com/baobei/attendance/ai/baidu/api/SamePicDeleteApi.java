package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.baobei.attendance.ai.baidu.api.entity.BaseReq;
import com.baobei.attendance.ai.baidu.api.entity.BaseRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author tcg
 * @date 2021/5/16
 */
@Component
public class SamePicDeleteApi extends Api<SamePicDeleteApi.SamePicDeleteReq, SamePicDeleteApi.SamePicDeleteRes> {
    public SamePicDeleteApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/realtime_search/same_hq/delete";
    }

    @Override
    public SamePicDeleteRes request(SamePicDeleteReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.postUrl(url, req, headers);
        SamePicDeleteApi.SamePicDeleteRes res = JSON.parseObject(resStr, SamePicDeleteApi.SamePicDeleteRes.class);
        res.setRawRes(resStr);
        return res;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class SamePicDeleteReq extends BaseReq {
        /**
         * 图片数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，（和url、cont_sign三选一，优先级：image > url > cont_sign），注意要去掉图片头部，如（data:image/jpg;base64,）。最短边至少50px，最长边最大4096px，支持jpg/png/bmp格式
         */
        @JSONField(name = "image")
        private String image;
        /**
         * 图片URL，和image、cont_sign三选一，image优先级更高，由于图床的差异性，抓图服务无法适配所有的图床，部分URL可能抓不到图，或者图片下载超时，遇到上述情况时请更换图片URL、或者将图片下载到本地转码后上传
         */
        @JSONField(name = "url")
        private String url;
        /**
         * 图片签名（和image、url三选一），支持批量删除，批量删除时请勿传image、url，最多支持50个cont_sign列表，样例："932301884,1068006219;316336521,553141152;2491030726,1352091083"
         */
        @JSONField(name = "cont_sign")
        private String contSign;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class SamePicDeleteRes extends BaseRes {
    }
}

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
public class SamePicAddApi extends Api<SamePicAddApi.SamePicAddReq, SamePicAddApi.SamePicAddRes> {
    public SamePicAddApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/realtime_search/same_hq/add";
        headers.put("Content-Type", "application/x-www-form-urlencoded");
    }

    @Override
    public SamePicAddRes request(SamePicAddReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.postUrl(url, req, headers);
        SamePicAddRes res = JSON.parseObject(resStr, SamePicAddRes.class);
        res.setRawRes(resStr);
        return res;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class SamePicAddReq extends BaseReq {
        /**
         * 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M。（和url二选一，image优先级更高），注意要去掉图片头部，如（data:image/jpg;base64,）；最短边至少50px，最长边最大4096px，支持jpg/png/bmp格式。重复添加完全相同的图片会返回错误，提示不能重复入库。
         */
        @JSONField(name = "image")
        private String image;
        /**
         * 图片URL，和image二选一，image优先级更高，由于图床的差异性，抓图服务无法适配所有的图床，部分URL可能抓不到图，或者图片下载超时，遇到上述情况时请更换图片URL、或者将图片下载到本地转码后上传
         */
        @JSONField(name = "url")
        private String url;
        /**
         * 检索时原样带回,最长256B。样例：{"name":"周杰伦", "id":"666"} 。请注意，检索接口不返回原图，仅返回入库时填写的brief信息，所以调用入库接口时，brief信息请尽量填写可关联至本地图库的图片id或者图片url、图片名称等信息
         */
        @JSONField(name = "brief")
        private String brief;
        /**
         * tag间以逗号分隔，最多2个tag，2个tag无层级关系，检索时支持逻辑运算。样例："100,11" ；检索时可圈定分类维度进行检索
         */
        @JSONField(name = "tags")
        private String tags;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class SamePicAddRes extends BaseRes {
        /**
         * 输入图片的签名信息，请务必保存至本地，以便后续用作批量删除、查询某张图是否已经入过库等用途
         */
        @JSONField(name = "cont_sign")
        private String contSign;
    }

}

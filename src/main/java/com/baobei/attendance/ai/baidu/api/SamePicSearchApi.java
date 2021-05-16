package com.baobei.attendance.ai.baidu.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.baobei.attendance.ai.baidu.api.entity.BaseReq;
import com.baobei.attendance.ai.baidu.api.entity.BaseRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2021/5/16
 */
@Component
public class SamePicSearchApi extends Api<SamePicSearchApi.SamePicSearchReq, SamePicSearchApi.SamePicSearchRes> {
    public SamePicSearchApi() {
        super();
        this.baseUrl = "https://aip.baidubce.com/rest/2.0/realtime_search/same_hq/search";
        headers.put("Content-Type", "application/x-www-form-urlencoded");
    }

    @Override
    public SamePicSearchRes request(SamePicSearchReq req) throws Exception {
        String url = getUrlWithToken();
        String resStr = httpUtil.postUrl(url, req, headers);
        SamePicSearchApi.SamePicSearchRes res = JSON.parseObject(resStr, SamePicSearchApi.SamePicSearchRes.class);
        res.setRawRes(resStr);
        return res;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class SamePicSearchReq extends BaseReq {
        /**
         * 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M。（和url二选一，image优先级更高），注意要去掉图片头部，如（data:image/jpg;base64,）；最短边至少50px，最长边最大4096px，支持jpg/png/bmp格式
         */
        @JSONField(name = "image")
        private String image;
        /**
         * 图片URL，和image二选一，image优先级更高，由于图床的差异性，抓图服务无法适配所有的图床，部分URL可能抓不到图，或者图片下载超时，遇到上述情况时请更换图片URL、或者将图片下载到本地转码后上传
         */
        @JSONField(name = "url")
        private String url;
        /**
         * 分类维度信息，tag间以逗号分隔，最多可传入2个tag，tag间无层级关系，示例："100,11"
         */
        @JSONField(name = "tags")
        private String tags;
        /**
         * 检索时tag之间的逻辑， 0：逻辑and，1：逻辑or
         */
        @JSONField(name = "tag_logic")
        private String tagLogic;
        /**
         * 分页功能，起始位置，例：0。未指定分页时，默认返回前300个结果；接口返回数量最大限制1000条，例如：起始位置为900，截取条数500条，接口也只返回第900 - 1000条的结果，共计100条
         */
        @JSONField(name = "pn")
        private String pn;
        /**
         * 分页功能，截取条数，例：250
         */
        @JSONField(name = "rn")
        private String rn;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class SamePicSearchRes extends BaseRes {
        /**
         * 检索结果数
         */
        @JSONField(name = "result_num")
        private Long resultNum;
        /**
         * 结果数组
         */
        @JSONField(name = "result")
        private List<Result> results;
        /**
         * 是否还有下一页，返回值：true、false；如果不分页，不用关注该字段
         */
        @JSONField(name = "has_more")
        private Boolean hasMore;

        @Data
        public static class Result {
            /**
             * 图片签名，可以用来删除图片或定位问题
             */
            @JSONField(name = "cont_sign")
            private String contSign;
            /**
             * 图片相关性，取值范围0-1，越接近1表示越相关
             */
            @JSONField(name = "score")
            private Double score;
            /**
             * 调用add接口时添加的brief信息，为保证该结果有效性，请入库时填写可关联至本地图片库的有效id信息
             */
            @JSONField(name = "brief")
            private String brief;
        }
    }
}

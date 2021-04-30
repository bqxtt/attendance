package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MultiSearchReq extends BaseReq {
    /**
     * 图片信息(数据大小应小于10M 分辨率应小于1920*1080)
     */
    @JSONField(name = "image")
    private String image;
    /**
     * 图片类型
     * BASE64:图片的base64值，base64编码后的图片数据，编码后的图片大小不超过2M；
     * URL:图片的 URL地址( 可能由于网络等原因导致下载图片时间过长)；
     * FACE_TOKEN：人脸图片的唯一标识，调用人脸检测接口时，会为每个人脸图片赋予一个唯一的FACE_TOKEN，同一张图片多次检测得到的FACE_TOKEN是同一个。
     */
    @JSONField(name = "image_type")
    private String imageType;
    /**
     * 从指定的group中进行查找 用逗号分隔，上限10个
     */
    @JSONField(name = "group_id_list")
    private String groupIdList;
    /**
     * 最多处理人脸的数目
     * 默认值为1(仅检测图片中面积最大的那个人脸) 最大值10
     */
    @JSONField(name = "max_face_num")
    private Integer maxFaceNum;
    /**
     * 匹配阈值（设置阈值后，score低于此阈值的用户信息将不会返回） 最大100 最小0 默认80
     * 此阈值设置得越高，检索速度将会越快，推荐使用默认阈值80
     */
    @JSONField(name = "match_threshold")
    private Integer matchThreshold;
    /**
     * 图片质量控制
     * NONE: 不进行控制
     * LOW:较低的质量要求
     * NORMAL: 一般的质量要求
     * HIGH: 较高的质量要求
     * 默认 NONE
     * 若图片质量不满足要求，则返回结果中会提示质量检测失败
     */
    @JSONField(name = "quality_control")
    private String qualityControl;
    /**
     * 活体检测控制
     * NONE: 不进行控制
     * LOW:较低的活体要求(高通过率 低攻击拒绝率)
     * NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率)
     * HIGH: 较高的活体要求(高攻击拒绝率 低通过率)
     * 默认NONE
     * 若活体检测结果不满足要求，则返回结果中会提示活体检测失败
     */
    @JSONField(name = "liveness_control")
    private String livenessControl;
    /**
     * 识别返回的最大用户数，默认为1，最大20个
     */
    @JSONField(name = "max_user_num")
    private Integer maxUserNum;
}

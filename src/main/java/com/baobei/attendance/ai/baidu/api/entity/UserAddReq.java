package com.baobei.attendance.ai.baidu.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserAddReq extends BaseReq {
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
    @JSONField(name = "group_id")
    private String groupId;
    @JSONField(name = "user_id")
    private String userId;
    @JSONField(name = "user_info")
    private String userInfo;
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
     * 操作方式
     * APPEND: 当user_id在库中已经存在时，对此user_id重复注册时，新注册的图片默认会追加到该user_id下
     * REPLACE : 当对此user_id重复注册时,则会用新图替换库中该user_id下所有图片
     * 默认使用APPEND
     */
    @JSONField(name = "action_type")
    private String actionType;
    /**
     * 人脸检测排序类型
     * 0:代表检测出的人脸按照人脸面积从大到小排列
     * 1:代表检测出的人脸按照距离图片中心从近到远排列
     * 默认为0
     */
    @JSONField(name = "face_sort_type")
    private Integer faceSortType;
}

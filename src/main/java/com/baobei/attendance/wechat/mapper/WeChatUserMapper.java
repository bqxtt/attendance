package com.baobei.attendance.wechat.mapper;

import com.baobei.attendance.entity.Student;
import com.baobei.attendance.wechat.entity.StudentInfo;
import com.baobei.attendance.wechat.entity.WeChatUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Mapper
@Component("weChatUserMapper")
public interface WeChatUserMapper {
    /**
     * 查找student
     *
     * @param studentNo
     * @return
     */
    Student findStudentByStudentNo(String studentNo);

    /**
     * 查找微信用户
     *
     * @param openId
     * @return
     */
    WeChatUser findWeChatUserByOpenId(String openId);

    /**
     * 查找学生
     *
     * @param studentId
     * @return
     */
    Student findStudentByStudentId(Long studentId);

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    Integer addWeChatUser(WeChatUser user);

    /**
     * 更新绑定信息
     *
     * @param user
     * @return
     */
    Integer updateWeChatUserByOpenId(WeChatUser user);

    /**
     * 更新学生信息 （微信端 修改部分）
     *
     * @param studentInfo
     * @return
     */
    Integer updateStudentInfo(StudentInfo studentInfo);

}

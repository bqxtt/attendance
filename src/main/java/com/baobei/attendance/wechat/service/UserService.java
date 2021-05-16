package com.baobei.attendance.wechat.service;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.wechat.entity.StudentInfo;

/**
 * @author tcg
 * @date 2021/4/14
 */
public interface UserService {

    /**
     * 获取用户openId
     *
     * @param userCode
     * @return
     */
    Result getUserOpenId(String userCode);

    /**
     * 绑定学生信息
     *
     * @param openId
     * @param username
     * @param stuNo
     * @return
     */
    Result bindStudentInfo(String openId, String username, String stuNo);

    /**
     * 绑定教师信息
     *
     * @param openId
     * @param account
     * @param password
     * @return
     */
    Result bindTeacherInfo(String openId, String account, String password);

    /**
     * 微信登录
     *
     * @param openId
     * @return
     */
    Result weChatLogin(String openId);

    /**
     * 更新学生信息（微信端 只能修改一部分）
     *
     * @param studentId
     * @param studentInfo
     * @return
     */
    Result updateStudentInfo(Long studentId, StudentInfo studentInfo);

    /**
     * 删除绑定信息
     *
     * @param openId
     * @return
     */
    Result deleteBindInfo(String openId);
}

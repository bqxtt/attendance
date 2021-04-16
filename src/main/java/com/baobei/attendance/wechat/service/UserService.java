package com.baobei.attendance.wechat.service;

import com.baobei.attendance.model.Result;

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
}

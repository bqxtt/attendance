package com.baobei.attendance.web.service;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.web.entity.WebUser;
import com.baobei.attendance.web.entity.WebUserSearch;

/**
 * @author tcg
 * @date 2021/4/13
 */
public interface UserService {

    /**
     * web 登录
     *
     * @param username
     * @param password
     * @return
     */
    Result webLogin(String account, String password);

    /**
     * 增加web admin
     *
     * @param user
     * @return
     */
    Result addAdmin(WebUser user);

    /**
     * 修改管理员信息
     *
     * @param adminId
     * @param user
     * @return
     */
    Result updateAdmin(Long adminId, WebUser user);

    /**
     * 删除管理员
     *
     * @param adminId
     * @return
     */
    Result deleteAdmin(Long adminId);

    /**
     * 获取管理员列表
     *
     * @param search
     * @return
     */
    Result getAdmins(WebUserSearch search);
}

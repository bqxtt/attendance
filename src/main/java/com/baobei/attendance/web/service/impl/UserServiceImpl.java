package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.model.PageInfo;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.web.entity.WebUser;
import com.baobei.attendance.web.entity.WebUserSearch;
import com.baobei.attendance.web.mapper.WebUserMapper;
import com.baobei.attendance.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tcg
 * @date 2021/4/13
 */
@Service("webUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    WebUserMapper webUserMapper;

    @Override
    public Result webLogin(String account, String password) {
        Result result;
        WebUser webUser = webUserMapper.findWebUserByAccount(account);
        if (webUser == null || !webUser.getPassword().equals(password)) {
            result = Result.retFail("登录信息有误");
        } else {
            //todo token
            result = Result.retOk("success");
        }
        return result;
    }

    @Override
    public Result addAdmin(WebUser user) {
        Result result;
        WebUser existUser = webUserMapper.findWebUserByAccount(user.getAccount());
        if (existUser != null) {
            result = Result.retFail("该管理员账号已存在");
        } else {
            webUserMapper.addWebUser(user);
            List<Long> classIds = user.getClassIds();
            if (classIds != null && classIds.size() > 0) {
                webUserMapper.addWebUserManagements(user.getId(), classIds);
            }
            List<Class> classes = webUserMapper.findWebUserClasses(classIds);
            user.setClasses(classes);
            Map<String, Object> data = new HashMap<>(1);
            data.put("user", user);
            result = Result.retOk("success", data);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updateAdmin(Long adminId, WebUser user) {
        Result result;
        if (!adminId.equals(user.getId())) {
            result = Result.retFail("admin id不一致");
        } else {
            webUserMapper.updateWebUser(user);
            List<Long> classIds = user.getClassIds();
            if (classIds != null && classIds.size() > 0) {
                webUserMapper.deleteWebUserManagements(user.getId());
                webUserMapper.addWebUserManagements(user.getId(), classIds);
                List<Class> classes = webUserMapper.findWebUserClasses(classIds);
                user.setClasses(classes);
            }
            Map<String, Object> data = new HashMap<>(1);
            data.put("user", user);
            result = Result.retOk("success", data);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result deleteAdmin(Long adminId) {
        Result result;
        webUserMapper.deleteWebUser(adminId);
        webUserMapper.deleteWebUserManagements(adminId);
        result = Result.retOk("success");
        return result;
    }

    @Override
    public Result getAdmins(WebUserSearch search) {
        search.normalize();
        Result result;
        try {
            Integer count = webUserMapper.findWebUserCountByCondition(search);
            List<WebUser> webUsers = webUserMapper.findWebUsersByCondition(search);
            PageInfo pageInfo = PageInfo.getPageInfo(count, search.getPageSize());
            Map<String, Object> data = new HashMap<>(2);
            data.put("pageInfo", pageInfo);
            data.put("users", webUsers);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }
}

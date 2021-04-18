package com.baobei.attendance.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.config.entity.Config;
import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.web.entity.WebUser;
import com.baobei.attendance.web.mapper.WebUserMapper;
import com.baobei.attendance.wechat.entity.UserStatus;
import com.baobei.attendance.wechat.entity.WeChatUser;
import com.baobei.attendance.wechat.mapper.WeChatUserMapper;
import com.baobei.attendance.wechat.service.UserService;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Service("weChatUserService")
public class UserServiceImpl implements UserService {
    @Value("${wechat.mini.program.auth-url}")
    private String authUrl;

    @Autowired
    private OkHttpClient httpClient;

    @Autowired
    private Config config;

    @Resource(name = "weChatUserMapper")
    WeChatUserMapper weChatUserMapper;

    @Resource(name = "webUserMapper")
    WebUserMapper webUserMapper;

    @Override
    public Result getUserOpenId(String userCode) {
        String url = authUrl + config.getAppId() + "&secret=" + config.getAppSecret() + "&js_code=" + userCode + "&grant_type=authorization_code";
        Result result;
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = httpClient.newCall(request);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                String res = JSON.parseObject(Objects.requireNonNull(response.body()).string()).getString("openid");
                if (res == null) {
                    result = Result.retFail("user code error, openid id is null");
                } else {
                    Map<String, Object> data = new HashMap<>(1);
                    data.put("openid", res);
                    result = Result.retOk(data);
                }
            } else {
                result = Result.retFail("weChat api error, please retry");
            }
        } catch (IOException e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result bindStudentInfo(String openId, String username, String stuNo) {
        Result result;
        Student student = weChatUserMapper.findStudentByStudentNo(stuNo);
        if (student == null || !student.getUsername().equals(username)) {
            result = Result.retFail("学生信息不存在");
        } else {
            try {
                WeChatUser user = new WeChatUser();
                user.setOpenId(openId);
                user.setStudentId(student.getId());
                user.setStatus(UserStatus.STUDENT.ordinal());
                weChatUserMapper.updateWeChatUserByOpenId(user);
                result = Result.retOk("success");
            } catch (Exception e) {
                result = Result.retFail(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public Result bindTeacherInfo(String openId, String account, String password) {
        Result result = new Result();
        WebUser user = webUserMapper.findWebUserByAccount(account);
        if (user == null || !user.getPassword().equals(password)) {
            result = Result.retFail("管理员信息不存在");
        } else {
            try {
                WeChatUser weChatUser = new WeChatUser();
                weChatUser.setStatus(UserStatus.TEACHER.ordinal());
                weChatUser.setWebUserId(user.getId());
                weChatUser.setOpenId(openId);
                weChatUserMapper.updateWeChatUserByOpenId(weChatUser);
                result = Result.retOk("success");
            } catch (Exception e) {
                result = Result.retFail(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public Result weChatLogin(String openId) {
        Result result;
        WeChatUser user = weChatUserMapper.findWeChatUserByOpenId(openId);
        if (user == null) {
            user = new WeChatUser();
            user.setOpenId(openId);
            user.setWebUserId(0L);
            user.setStatus(UserStatus.UNBIND.ordinal());
            user.setStudentId(0L);
            try {
                weChatUserMapper.addWeChatUser(user);
                Map<String, Object> data = new HashMap<>(1);
                data.put("user", user);
                result = Result.retOk("login success", data);
            } catch (Exception e) {
                result = Result.retFail(e.getMessage());
            }
        } else {
            Integer status = user.getStatus();
            if (status == UserStatus.STUDENT.ordinal()) {
                Student student = weChatUserMapper.findStudentByStudentId(user.getStudentId());
                user.setStudent(student);
            } else if (status == UserStatus.TEACHER.ordinal()) {
                WebUser teacher = webUserMapper.findWebUserByWebUserId(user.getWebUserId());
                user.setWebUser(teacher);
            }
            Map<String, Object> data = new HashMap<>(1);
            data.put("user", user);
            result = Result.retOk("login success", data);
        }
        return result;
    }
}

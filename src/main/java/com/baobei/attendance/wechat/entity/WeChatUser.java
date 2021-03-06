package com.baobei.attendance.wechat.entity;

import com.baobei.attendance.entity.Student;
import com.baobei.attendance.web.entity.WebUser;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Data
public class WeChatUser {
    private Long id;
    private String openId;
    private Long webUserId;
    private WebUser webUser;
    private Long studentId;
    private Student student;
    private Integer status;
    private Date registerTime;
    private String registerDate;

    public String getRegisterDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (registerTime != null) {
            return formatter.format(registerTime);
        }
        return "";
    }
}

package com.baobei.attendance.wechat.controller;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.wechat.entity.StudentAuth;
import com.baobei.attendance.wechat.entity.TeacherAuth;
import com.baobei.attendance.wechat.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Api(tags = "用户接口")
@RestController("weChatUserController")
@RequestMapping("/weChat")
@CrossOrigin
public class UserController {

    @Resource(name = "weChatUserService")
    UserService userService;

    @ApiOperation("获取openId")
    @GetMapping("/openId")
    public ResponseEntity<Result> getUserOpenId(@RequestParam(required = true) String userCode) {
        Result result = userService.getUserOpenId(userCode);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestParam(required = true) String openId) {
        Result result = userService.weChatLogin(openId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("绑定学生信息")
    @PostMapping("/student/bind")
    public ResponseEntity<Result> stuBind(@RequestBody StudentAuth studentAuth) {
        Result result = userService.bindStudentInfo(studentAuth.getOpenId(), studentAuth.getUsername(), studentAuth.getStuNo());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("绑定教师信息")
    @PostMapping("/teacher/bind")
    public ResponseEntity<Result> teacherBind(@RequestBody TeacherAuth teacherAuth) {
        Result result = userService.bindTeacherInfo(teacherAuth.getOpenId(), teacherAuth.getUsername(), teacherAuth.getPassword());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

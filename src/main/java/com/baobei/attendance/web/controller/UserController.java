package com.baobei.attendance.web.controller;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.web.entity.UserAuth;
import com.baobei.attendance.web.entity.WebUser;
import com.baobei.attendance.web.entity.WebUserSearch;
import com.baobei.attendance.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tcg
 * @date 2021/4/13
 */
@Api(tags = "用户管理")
@RestController("webUserController")
@RequestMapping("/web")
public class UserController {
    @Resource(name = "webUserService")
    UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody UserAuth userAuth) {
        Result result = userService.webLogin(userAuth.getAccount(), userAuth.getPassword());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("超管添加管理员")
    @PutMapping("/admin")
    public ResponseEntity<Result> addAdmin(@RequestBody WebUser user) {
        Result result;
        try {
            result = userService.addAdmin(user);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("修改管理员")
    @PostMapping("/admin/{adminId}")
    public ResponseEntity<Result> updateAdmin(@RequestBody WebUser user, @PathVariable Long adminId) {
        Result result;
        try {
            result = userService.updateAdmin(adminId, user);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("删除管理员")
    @DeleteMapping("/admin/{adminId}")
    public ResponseEntity<Result> deleteAdmin(@PathVariable Long adminId) {
        Result result;
        try {
            result = userService.deleteAdmin(adminId);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("管理员列表")
    @PostMapping("/admins")
    public ResponseEntity<Result> getAdmins(@RequestBody WebUserSearch search) {
        Result result = userService.getAdmins(search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

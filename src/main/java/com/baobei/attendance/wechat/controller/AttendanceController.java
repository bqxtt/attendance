package com.baobei.attendance.wechat.controller;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.wechat.entity.Records;
import com.baobei.attendance.wechat.service.AttendanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tcg
 * @date 2021/3/27
 */
@Api(tags = "打卡接口")
@RestController
@RequestMapping("/weChat")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @ApiOperation("上传打卡照片")
    @PostMapping("/photo")
    public ResponseEntity<Result> uploadPhoto(@RequestParam("photo") MultipartFile photo) {
        Result result = attendanceService.uploadPhoto(photo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("上报打卡记录")
    @PostMapping("/records")
    public ResponseEntity<Result> uploadRecords(@RequestBody Records records) {
        Result result = attendanceService.addStudentRecords(records);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

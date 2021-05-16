package com.baobei.attendance.wechat.controller;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.service.FaceRepoService;
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

    @ApiOperation("查询今日打卡记录")
    @GetMapping("/record/{studentId}")
    public ResponseEntity<Result> queryRecord(@PathVariable Long studentId) {
        Result result = attendanceService.queryRecord(studentId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Autowired
    FaceRepoService faceRepoService;

    @ApiOperation("新增重复照片")
    @PostMapping("/test/record/same/pic/add")
    public ResponseEntity<Result> samePicAdd(@RequestParam("picture") MultipartFile picture) {
        Result result = attendanceService.samePicAdd(picture);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("判断重复照片")
    @PostMapping("/test/record/same/pic/search")
    public ResponseEntity<Result> samePicSearch(@RequestParam("picture") MultipartFile picture) {
        Result result = attendanceService.samePicSearch(picture);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

package com.baobei.attendance.web.controller;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.StudentSearch;
import com.baobei.attendance.web.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author tcg
 * @date 2021/5/8
 */
@Api(tags = "打卡记录管理")
@RestController
@RequestMapping("/web/record")
@CrossOrigin
public class RecordController {
    @Autowired
    RecordService recordService;

    @ApiOperation("获取学院打卡情况")
    @GetMapping("/department")
    public ResponseEntity<Result> getDepartmentRecords() {
        Result result = recordService.getDepartmentRecords();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("获取打卡记录列表")
    @PostMapping("/list")
    public ResponseEntity<Result> getRecordList(@RequestBody StudentSearch search) {
        Result result = recordService.getRecordList(search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

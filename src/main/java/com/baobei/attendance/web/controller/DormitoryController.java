package com.baobei.attendance.web.controller;

import com.baobei.attendance.entity.Dormitory;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.DormitorySearch;
import com.baobei.attendance.web.service.DormitoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Api(tags = "宿舍管理")
@RestController
@RequestMapping("/web")
@CrossOrigin
public class DormitoryController {
    @Autowired
    DormitoryService dormitoryService;

    @ApiOperation("添加宿舍")
    @PostMapping("/dormitories")
    public ResponseEntity<Result> addDormitories(@RequestBody List<Dormitory> dormitories) {
        Result result = dormitoryService.addDormitories(dormitories);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("修改宿舍")
    @PutMapping("/dormitory/{dormitoryId}")
    public ResponseEntity<Result> updateDormitory(@RequestBody Dormitory dormitory, @PathVariable Long dormitoryId) {
        Result result = dormitoryService.updateDormitory(dormitoryId, dormitory);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("删除宿舍")
    @DeleteMapping("/dormitory/{dormitoryId}")
    public ResponseEntity<Result> deleteDormitory(@PathVariable Long dormitoryId) {
        Result result = dormitoryService.deleteDormitory(dormitoryId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("宿舍列表")
    @PostMapping("/dormitories/list")
    public ResponseEntity<Result> getDormitories(@RequestBody DormitorySearch search) {
        Result result = dormitoryService.getDormitories(search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("添加宿舍学生")
    @PutMapping("/dormitory/student")
    public ResponseEntity<Result> addDormitoryStudent(@RequestParam Long dormitoryId, @RequestParam Long studentId) {
        Result result = dormitoryService.addDormitoryStudent(dormitoryId, studentId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("删除宿舍学生")
    @DeleteMapping("/dormitory/student")
    public ResponseEntity<Result> deleteDormitoryStudent(@RequestParam Long studentId, @RequestParam Long dormitoryId) {
        Result result = dormitoryService.deleteDormitoryStudent(dormitoryId, studentId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ApiOperation("查找宿舍是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dormitoryId", value = "宿舍ID", required = false, paramType = "query"),
            @ApiImplicitParam(name = "roomName", value = "宿舍标识", required = false, paramType = "query")
    })
    @GetMapping("/dormitory")
    public ResponseEntity<Result> findDormitory(@RequestParam(required = false) Long dormitoryId, @RequestParam(required = false) String roomName) {
        Result result;
        if (dormitoryId != null) {
            result = dormitoryService.findDormitoryById(dormitoryId);
        } else if (roomName != null) {
            result = dormitoryService.findDormitoryByRoomName(roomName);
        } else {
            return new ResponseEntity<>(Result.retFail("no parameter"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

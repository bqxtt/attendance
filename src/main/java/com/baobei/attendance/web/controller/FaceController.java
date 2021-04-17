package com.baobei.attendance.web.controller;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.web.service.FaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Api(tags = "人脸库管理")
@RestController
@RequestMapping("/web")
public class FaceController {
    @Autowired
    FaceService faceService;

    @ApiOperation("上传或更新人脸图片")
    @PostMapping("/face/{studentId}")
    public ResponseEntity<Result> uploadFace(@PathVariable Long studentId, @RequestParam("face") MultipartFile faceFile) {
        Result result;
        try {
            result = faceService.uploadStudentFace(studentId, faceFile);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("删除人脸图片")
    @DeleteMapping("/face/{studentId}")
    public ResponseEntity<Result> deleteFace(@PathVariable Long studentId) {
        Result result;
        try {
            result = faceService.deleteStudentFace(studentId);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

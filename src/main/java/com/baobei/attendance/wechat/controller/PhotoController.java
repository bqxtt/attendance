package com.baobei.attendance.wechat.controller;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.wechat.service.PhotoUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tcg
 * @date 2021/3/27
 */
@RestController
public class PhotoController {
    @Autowired
    PhotoUploadService photoUploadService;

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadPhoto(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(Result.retFail("file empty"), HttpStatus.BAD_REQUEST);
        }
        String url = photoUploadService.upload(file);
        Map<String, Object> data = new HashMap<>(1);
        data.put("url", url);
        if (url != null) {
            return new ResponseEntity<>(Result.retOk(data), HttpStatus.OK);
        }
        return new ResponseEntity<>(Result.retFail("upload error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

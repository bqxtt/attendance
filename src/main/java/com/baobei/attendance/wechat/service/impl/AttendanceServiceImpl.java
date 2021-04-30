package com.baobei.attendance.wechat.service.impl;

import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.service.FaceRepoService;
import com.baobei.attendance.web.mapper.StudentMapper;
import com.baobei.attendance.wechat.entity.Records;
import com.baobei.attendance.wechat.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author tcg
 * @date 2021/4/18
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    FaceRepoService faceRepoService;
    @Autowired
    StudentMapper studentMapper;

    private String getFilepath(String filename) {
        int pos = filename.lastIndexOf(".");
        if (pos < 0) {
            return null;
        }
        String suffix = filename.substring(pos);
        long time = System.currentTimeMillis();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return "records/" + date + "/" + time + suffix;
    }

    @Override
    public Result uploadPhoto(MultipartFile photo) {
        Result result;
        try {
            String filePath = getFilepath(Objects.requireNonNull(photo.getOriginalFilename()));
            String url = faceRepoService.uploadToOss(photo, filePath);
            List<String> studentNos = faceRepoService.faceMultiSearch(url);
            List<Student> students = studentMapper.findStudentByStuNos(studentNos);
            Map<String, Object> data = new HashMap<>(1);
            data.put("students", students);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result addStudentRecords(Records records) {
        //todo
        return Result.retOk("");
    }
}

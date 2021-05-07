package com.baobei.attendance.wechat.service.impl;

import com.baobei.attendance.entity.Record;
import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.service.FaceRepoService;
import com.baobei.attendance.utils.JWTUtil;
import com.baobei.attendance.web.mapper.StudentMapper;
import com.baobei.attendance.wechat.entity.Records;
import com.baobei.attendance.wechat.mapper.RecordMapper;
import com.baobei.attendance.wechat.service.AttendanceService;
import io.jsonwebtoken.Claims;
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
    @Autowired
    RecordMapper recordMapper;

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

    private Map<String, Object> getClaims(List<Student> students) {
        Map<String, Object> claims = new HashMap<>(students.size());
        for (Student student : students) {
            claims.put(student.getStuNo(), student.getUsername());
        }
        return claims;
    }

    private void verifyToken(Records records) throws Exception {
        if (records.getToken() == null) {
            throw new Exception("token is null");
        }
        Claims claims = JWTUtil.parseToken(records.getToken());
        for (Record record : records.getRecords()) {
            record.setRecordTime(new Date());
            if (!record.getUsername().equals(claims.get(record.getStudentNo()))) {
                throw new Exception("verify token failed, token message modified");
            }
        }
    }

    @Override
    public Result uploadPhoto(MultipartFile photo) {
        Result result;
        try {
            String filePath = getFilepath(Objects.requireNonNull(photo.getOriginalFilename()));
            String url = faceRepoService.uploadToOss(photo, filePath);
            List<String> studentNos = faceRepoService.faceMultiSearch(url);
            List<Student> students = studentMapper.findStudentByStuNos(studentNos);
            Map<String, Object> data = new HashMap<>(3);
            data.put("students", students);
            data.put("token", JWTUtil.generateToken(getClaims(students)));
            data.put("url", url);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result addStudentRecords(Records records) {
        Result result;
        try {
            verifyToken(records);
            recordMapper.addStudentRecords(records.getRecords());
            result = Result.retOk("success");
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result queryRecord(Long studentId) {
//        Result result;
//        try {
//            recordMapper.findRecordsByCondition()
//        }
        return null;
    }
}

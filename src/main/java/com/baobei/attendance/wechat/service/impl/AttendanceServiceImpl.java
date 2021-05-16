package com.baobei.attendance.wechat.service.impl;

import com.baobei.attendance.ai.baidu.api.entity.Brief;
import com.baobei.attendance.entity.Record;
import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.RecordCondition;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.service.FaceRepoService;
import com.baobei.attendance.utils.JWTUtil;
import com.baobei.attendance.web.mapper.StudentMapper;
import com.baobei.attendance.web.mapper.WebRecordMapper;
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
    @Autowired
    WebRecordMapper webRecordMapper;

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
            Map<String, Object> data = new HashMap<>(3);
            //检测照片是否使用过
            Brief brief = faceRepoService.samePicSearch(url);
            if (brief != null && brief.getScore() > 0.9) {
                data.put("brief", brief);
                result = Result.retFail("照片已于" + brief.getRecordTime() + "使用过", data);
                return result;
            }
            List<String> studentNos = faceRepoService.faceMultiSearch(url);
            List<Student> students = studentMapper.findStudentByStuNos(studentNos);
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
        Date now = new Date();
        try {
            //verifyToken(records);
            List<Long> studentIds = new ArrayList<>();
            for (Record record : records.getRecords()) {
                record.setRecordTime(now);
                studentIds.add(record.getStudentId());
            }
            RecordCondition condition = new RecordCondition();
            condition.setStudentIds(studentIds);
            condition.normalizeWithDate(0);
            List<Record> hasRecords = webRecordMapper.findRecordsByCondition(condition);
            Map<Long, Record> stuRecord = new HashMap<>(hasRecords.size());
            for (Record record : hasRecords) {
                stuRecord.put(record.getStudentId(), record);
            }
            List<Record> needRecords = new ArrayList<>();
            for (Record record : records.getRecords()) {
                if (stuRecord.containsKey(record.getStudentId())) {
                    continue;
                }
                needRecords.add(record);
            }
            if (needRecords.size() > 0) {
                recordMapper.addStudentRecords(needRecords);
                //保存使用过的打卡照片
                Brief brief = new Brief();
                brief.setRecordTime(new SimpleDateFormat("yyyy-MM-dd").format(now));
                faceRepoService.samePicAdd(needRecords.get(0).getPhotoUrl(), brief);
            }
            result = Result.retOk("success");
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result queryRecord(Long studentId) {
        Result result;
        try {
            RecordCondition condition = new RecordCondition();
            List<Long> studentIds = new ArrayList<>();
            studentIds.add(studentId);
            condition.setStudentIds(studentIds);
            condition.normalizeWithDate(0);
            Integer count = webRecordMapper.findRecordsCountByCondition(condition);
            Boolean status = (count > 0);
            Map<String, Object> data = new HashMap<>(1);
            data.put("status", status);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result samePicAdd(MultipartFile picture) {
        Result result;
        try {
            String url = faceRepoService.uploadToOss(picture, getFilepath(Objects.requireNonNull(picture.getOriginalFilename())));
            Brief brief = new Brief();
            brief.setRecordTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            faceRepoService.samePicAdd(url, brief);
            result = Result.retOk("success");
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result samePicSearch(MultipartFile picture) {
        Result result;
        try {
            String url = faceRepoService.uploadToOss(picture, getFilepath(Objects.requireNonNull(picture.getOriginalFilename())));
            Brief brief = faceRepoService.samePicSearch(url);
            Map<String, Object> data = new HashMap<>(1);
            data.put("brief", brief);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }
}

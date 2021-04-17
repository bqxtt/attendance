package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.service.PhotoUploadService;
import com.baobei.attendance.web.entity.Face;
import com.baobei.attendance.web.mapper.FaceMapper;
import com.baobei.attendance.web.mapper.StudentMapper;
import com.baobei.attendance.web.service.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Service
public class FaceServiceImpl implements FaceService {
    @Autowired
    PhotoUploadService uploadService;
    @Autowired
    FaceMapper faceMapper;
    @Autowired
    StudentMapper studentMapper;

    private String getFilepath(String stuNo, String filename) {
        int pos = filename.lastIndexOf(".");
        if (pos < 0) {
            return null;
        }
        String suffix = filename.substring(pos);
        long time = System.currentTimeMillis();
        return "faces/" + stuNo + "_" + time + suffix;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result uploadStudentFace(Long studentId, MultipartFile faceFile) {
        Student student = studentMapper.findStudentById(studentId);
        if (student == null) {
            return Result.retFail("学生不存在");
        }
        Result result;
        String filepath = getFilepath(student.getStuNo(), Objects.requireNonNull(faceFile.getOriginalFilename()));
        if (filepath == null) {
            result = Result.retFail("file error");
        } else {
            String url = uploadService.upload(faceFile, filepath);
            if (url == null) {
                result = Result.retFail("upload fail");
            } else {
                Face face = new Face();
                face.setStudentId(studentId);
                face.setUrl(url);
                student.setFaceUrl(url);
                faceMapper.addOrModifyStudentFace(face);
                studentMapper.updateStudent(student);
                Map<String, Object> data = new HashMap<>(1);
                data.put("student", student);
                result = Result.retOk("success", data);
            }
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result deleteStudentFace(Long studentId) {
        Student student = studentMapper.findStudentById(studentId);
        if (student == null) {
            return Result.retFail("学生不存在");
        }
        student.setFaceUrl("");
        faceMapper.deleteStudentFace(studentId);
        studentMapper.updateStudent(student);
        Map<String, Object> data = new HashMap<>(1);
        data.put("student", student);
        return Result.retOk("success", data);
    }
}

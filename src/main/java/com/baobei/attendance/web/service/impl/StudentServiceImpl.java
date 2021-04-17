package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.entity.*;
import com.baobei.attendance.model.PageInfo;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.StudentSearch;
import com.baobei.attendance.web.mapper.DormitoryMapper;
import com.baobei.attendance.web.mapper.SchoolMapper;
import com.baobei.attendance.web.mapper.StudentMapper;
import com.baobei.attendance.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SchoolMapper schoolMapper;

    @Autowired
    DormitoryMapper dormitoryMapper;

    @Override
    public Result batchSaveStudent(List<Student> students) {
        Result result;
        try {
            studentMapper.addStudents(students);
            Map<String, Object> data = new HashMap<>(1);
            data.put("students", students);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result updateStudent(Long studentId, Student student) {
        Result result;
        if (!studentId.equals(student.getId())) {
            result = Result.retFail("student id不一致");
        } else {
            try {
                studentMapper.updateStudent(student);
                Map<String, Object> data = new HashMap<>(1);
                data.put("student", student);
                result = Result.retOk("success", data);
            } catch (Exception e) {
                result = Result.retFail(e.getMessage());
            }
        }
        return result;
    }


    @Override
    public Result batchDeleteStudents(List<Long> studentIds) {
        Result result;
        try {
            studentMapper.deleteStudents(studentIds);
            result = Result.retOk("success");
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result getStudents(StudentSearch search) {
        search.normalize();
        Result result;
        try {
            Integer count = studentMapper.findStudentCountByCondition(search);
            List<Student> students = studentMapper.findStudentsByCondition(search);
            for (Student student : students) {
                Department department = schoolMapper.findDepartmentById(student.getDepartmentId());
                Major major = schoolMapper.findMajorById(student.getMajorId());
                Class clazz = schoolMapper.findClassById(student.getClassId());
                Dormitory dormitory = dormitoryMapper.findDormitoryById(student.getDormitoryId());
                student.setAClass(clazz);
                student.setDepartment(department);
                student.setMajor(major);
                student.setDormitory(dormitory);
            }
            PageInfo pageInfo = PageInfo.getPageInfo(count, search.getPageSize());
            Map<String, Object> data = new HashMap<>(2);
            data.put("pageInfo", pageInfo);
            data.put("students", students);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }
}

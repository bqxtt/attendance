package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.entity.Department;
import com.baobei.attendance.entity.Major;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.web.service.SchoolService;
import org.springframework.stereotype.Service;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Service
public class SchoolServiceImpl implements SchoolService {
    @Override
    public Result addDepartment(Department department) {
        return Result.retOk("success");
    }

    @Override
    public Result updateDepartment(Long departmentId, Department department) {
        return Result.retOk("success");
    }

    @Override
    public Result deleteDepartment(Long departmentId) {
        return Result.retOk("success");
    }

    @Override
    public Result getDepartments() {
        return Result.retOk("success");
    }

    @Override
    public Result addMajor(Major major) {
        return Result.retOk("success");
    }

    @Override
    public Result updateMajor(Long majorId, Major major) {
        return Result.retOk("success");
    }

    @Override
    public Result deleteMajor(Long majorId) {
        return Result.retOk("success");
    }

    @Override
    public Result getMajors() {
        return Result.retOk("success");
    }

    @Override
    public Result addClass(Class clazz) {
        return Result.retOk("success");
    }

    @Override
    public Result updateClass(Long classId, Class clazz) {
        return Result.retOk("success");
    }

    @Override
    public Result deleteClass(Long classId) {
        return Result.retOk("success");
    }

    @Override
    public Result getClasses() {
        return Result.retOk("success");
    }
}

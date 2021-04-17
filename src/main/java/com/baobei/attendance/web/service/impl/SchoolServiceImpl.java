package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.entity.Department;
import com.baobei.attendance.entity.Major;
import com.baobei.attendance.model.PageInfo;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.ClassSearch;
import com.baobei.attendance.model.search.DepartmentSearch;
import com.baobei.attendance.model.search.MajorSearch;
import com.baobei.attendance.web.mapper.SchoolMapper;
import com.baobei.attendance.web.service.SchoolService;
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
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolMapper schoolMapper;

    @Override
    public Result addDepartment(Department department) {
        Result result;
        try {
            schoolMapper.addDepartment(department);
            Map<String, Object> data = new HashMap<>(1);
            data.put("department", department);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result updateDepartment(Long departmentId, Department department) {
        Result result;
        if (!departmentId.equals(department.getId())) {
            result = Result.retFail("department id不一致");
        } else {
            try {
                schoolMapper.updateDepartment(department);
                Map<String, Object> data = new HashMap<>(1);
                data.put("department", department);
                result = Result.retOk("success", data);
            } catch (Exception e) {
                result = Result.retFail(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public Result deleteDepartment(Long departmentId) {
        Result result;
        try {
            schoolMapper.deleteDepartmentById(departmentId);
            result = Result.retOk("success");
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result getDepartments(DepartmentSearch search) {
        Result result;
        try {
            Integer count = schoolMapper.findDepartmentCountByCondition(search);
            List<Department> departments = schoolMapper.findDepartmentsByCondition(search);
            PageInfo pageInfo = PageInfo.getPageInfo(count, search.getPageSize());
            Map<String, Object> data = new HashMap<>(2);
            data.put("pageInfo", pageInfo);
            data.put("departments", departments);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result addMajor(Major major) {
        Result result;
        try {
            schoolMapper.addMajor(major);
            Map<String, Object> data = new HashMap<>(1);
            data.put("major", major);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result updateMajor(Long majorId, Major major) {
        Result result;
        if (!majorId.equals(major.getId())) {
            result = Result.retFail("major id不一致");
        } else {
            try {
                schoolMapper.updateMajor(major);
                Map<String, Object> data = new HashMap<>(1);
                data.put("major", major);
                result = Result.retOk("success", data);
            } catch (Exception e) {
                result = Result.retFail(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public Result deleteMajor(Long majorId) {
        Result result;
        try {
            schoolMapper.deleteMajorById(majorId);
            result = Result.retOk("success");
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result getMajors(MajorSearch search) {
        Result result;
        try {
            Integer count = schoolMapper.findMajorCountByCondition(search);
            List<Major> majors = schoolMapper.findMajorsByCondition(search);
            PageInfo pageInfo = PageInfo.getPageInfo(count, search.getPageSize());
            Map<String, Object> data = new HashMap<>(2);
            data.put("pageInfo", pageInfo);
            data.put("majors", majors);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result addClass(Class clazz) {
        Result result;
        try {
            schoolMapper.addClass(clazz);
            Map<String, Object> data = new HashMap<>(1);
            data.put("class", clazz);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result updateClass(Long classId, Class clazz) {
        Result result;
        if (!classId.equals(clazz.getId())) {
            result = Result.retFail("class id不一致");
        } else {
            try {
                schoolMapper.updateClass(clazz);
                Map<String, Object> data = new HashMap<>(1);
                data.put("class", clazz);
                result = Result.retOk("success", data);
            } catch (Exception e) {
                result = Result.retFail(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public Result deleteClass(Long classId) {
        Result result;
        try {
            schoolMapper.deleteClassById(classId);
            result = Result.retOk("success");
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result getClasses(ClassSearch search) {
        Result result;
        try {
            Integer count = schoolMapper.findClassCountByCondition(search);
            List<Class> classes = schoolMapper.findClassesByCondition(search);
            PageInfo pageInfo = PageInfo.getPageInfo(count, search.getPageSize());
            Map<String, Object> data = new HashMap<>(2);
            data.put("pageInfo", pageInfo);
            data.put("classes", classes);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }
}

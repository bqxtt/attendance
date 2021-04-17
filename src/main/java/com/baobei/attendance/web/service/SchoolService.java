package com.baobei.attendance.web.service;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.entity.Department;
import com.baobei.attendance.entity.Major;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.ClassSearch;
import com.baobei.attendance.model.search.DepartmentSearch;
import com.baobei.attendance.model.search.MajorSearch;

/**
 * @author tcg
 * @date 2021/4/14
 */
public interface SchoolService {
    /**
     * 增加学院
     *
     * @param department
     * @return
     */
    Result addDepartment(Department department);

    /**
     * 修改学院
     *
     * @param departmentId
     * @param department
     * @return
     */
    Result updateDepartment(Long departmentId, Department department);

    /**
     * 删除学院
     *
     * @param departmentId
     * @return
     */
    Result deleteDepartment(Long departmentId);

    /**
     * 获取学院
     *
     * @param search
     * @return
     */
    Result getDepartments(DepartmentSearch search);

    /**
     * 增加专业
     *
     * @param major
     * @return
     */
    Result addMajor(Major major);

    /**
     * 修改专业
     *
     * @param majorId
     * @param major
     * @return
     */
    Result updateMajor(Long majorId, Major major);

    /**
     * 删除专业
     *
     * @param majorId
     * @return
     */
    Result deleteMajor(Long majorId);

    /**
     * 获取专业
     *
     * @param search
     * @return
     */
    Result getMajors(MajorSearch search);

    /**
     * 增加班级
     *
     * @param clazz
     * @return
     */
    Result addClass(Class clazz);

    /**
     * 修改班级
     *
     * @param classId
     * @param clazz
     * @return
     */
    Result updateClass(Long classId, Class clazz);

    /**
     * 删除班级
     *
     * @param classId
     * @return
     */
    Result deleteClass(Long classId);

    /**
     * 获取班级
     *
     * @param search
     * @return
     */
    Result getClasses(ClassSearch search);
}

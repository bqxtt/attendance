package com.baobei.attendance.web.service;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.ClassSearch;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/14
 */
public interface SchoolService {
    /**
     * 增加班级
     *
     * @param classes
     * @return
     */
    Result addClasses(List<Class> classes);

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

    /**
     * 获取学院专业班级所有信息
     *
     * @return
     */
    Result getSchoolAll();

    /**
     * 获取学生、辅导员、宿舍数量
     *
     * @return
     */
    Result getCount();
}

package com.baobei.attendance.web.service;

import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.StudentSearch;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/14
 */
public interface StudentService {
    /**
     * 批量保存学生信息
     *
     * @param students
     * @return
     */
    Result batchSaveStudent(List<Student> students);

    /**
     * 修改学生信息
     *
     * @param studentId
     * @param student
     * @return
     */
    Result updateStudent(Long studentId, Student student);

    /**
     * 批量删除学生
     *
     * @param studentIds
     * @return
     */
    Result batchDeleteStudents(List<Long> studentIds);

    /**
     * 获取所有学生
     *
     * @param search
     * @return
     */
    Result getStudents(StudentSearch search);
}

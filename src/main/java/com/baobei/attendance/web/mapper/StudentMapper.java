package com.baobei.attendance.web.mapper;

import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.search.StudentSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/15
 */
@Mapper
@Component
public interface StudentMapper {
    /**
     * 条件查找学生
     *
     * @param search
     * @return
     */
    List<Student> findStudentsByCondition(StudentSearch search);

    /**
     * 数量 分页
     *
     * @param search
     * @return
     */
    Integer findStudentCountByCondition(StudentSearch search);

    /**
     * 批量添加
     *
     * @param students
     * @return
     */
    Integer addStudents(List<Student> students);

    /**
     * 批量删除
     *
     * @param studentsId
     * @return
     */
    Integer deleteStudents(List<Long> studentsId);

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    Integer updateStudent(Student student);
}

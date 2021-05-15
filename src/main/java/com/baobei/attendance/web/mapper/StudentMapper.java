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
     * 获取宿舍学生
     *
     * @param dormitoryId
     * @return
     */
    List<Student> findStudentsByDormitoryId(Long dormitoryId);

    /**
     * 获取班级学生
     *
     * @param classIds
     * @return
     */
    List<Student> findStudentsByClassIds(List<Long> classIds);

    /**
     * 数量 分页
     *
     * @param search
     * @return
     */
    Integer findStudentCountByCondition(StudentSearch search);

    /**
     * id查
     *
     * @param id
     * @return
     */
    Student findStudentById(Long id);

    /**
     * 学号查
     *
     * @param stuNos
     * @return
     */
    List<Student> findStudentByStuNos(List<String> stuNos);

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

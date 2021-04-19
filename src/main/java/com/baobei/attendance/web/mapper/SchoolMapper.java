package com.baobei.attendance.web.mapper;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.entity.Department;
import com.baobei.attendance.entity.Major;
import com.baobei.attendance.model.search.ClassSearch;
import com.baobei.attendance.model.search.DepartmentSearch;
import com.baobei.attendance.model.search.MajorSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Mapper
@Component
public interface SchoolMapper {
    /**
     * @param department
     * @return
     */
    Integer addDepartment(Department department);

    Integer addMajor(Major major);

    Integer addClass(Class clazz);

    Integer updateDepartment(Department department);

    Integer updateMajor(Major major);

    Integer updateClass(Class clazz);

    Integer deleteDepartmentById(Long id);

    Integer deleteMajorById(Long id);

    Integer deleteClassById(Long id);

    List<Department> findDepartmentsByCondition(DepartmentSearch search);

    Integer findDepartmentCountByCondition(DepartmentSearch search);

    Department findDepartmentById(Long id);

    List<Department> findAllDepartments();

    List<Long> findDepartmentIdsByName(@Param("departmentName") String departmentName);

    List<Major> findMajorsByCondition(MajorSearch search);

    Integer findMajorCountByCondition(MajorSearch search);

    Major findMajorById(Long id);

    List<Major> findMajorsByDepartmentId(Long departmentId);

    List<Long> findMajorIdsByName(@Param("majorName") String majorName);

    List<Class> findClassesByCondition(ClassSearch search);

    Integer findClassCountByCondition(ClassSearch search);

    Class findClassById(Long id);

    List<Class> findClassesByMajorId(Long majorId);
}

package com.baobei.attendance.web.mapper;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.entity.Department;
import com.baobei.attendance.entity.Major;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

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


}

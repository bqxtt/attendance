package com.baobei.attendance.web.mapper;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.model.search.ClassSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Mapper
@Component
public interface SchoolMapper {

    Integer addClass(Class clazz);


    Integer updateClass(Class clazz);


    Integer deleteClassById(Long id);


    List<Class> findClassesByCondition(ClassSearch search);

    Integer findClassCountByCondition(ClassSearch search);

    Class findClassById(Long id);

    List<Class> findAllClasses();

}

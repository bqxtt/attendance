package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.model.PageInfo;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.ClassSearch;
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
    public Result addClasses(List<Class> classes) {
        Result result;
        try {
            schoolMapper.addClasses(classes);
            Map<String, Object> data = new HashMap<>(1);
            data.put("classes", classes);
            result = Result.retOk(data);
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
        search.normalize();
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

    @Override
    public Result getSchoolAll() {
        Result result = null;
        //todo
        List<Class> classes = schoolMapper.findAllClasses();
//        Map<String, Object> data = new HashMap<>(1);
//        data.put("all", departments);
//        result = Result.retOk(data);
        return result;
    }
}

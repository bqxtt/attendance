package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.model.PageInfo;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.ClassSearch;
import com.baobei.attendance.model.search.DormitorySearch;
import com.baobei.attendance.model.search.StudentSearch;
import com.baobei.attendance.web.entity.Cascader;
import com.baobei.attendance.web.entity.WebUserSearch;
import com.baobei.attendance.web.mapper.DormitoryMapper;
import com.baobei.attendance.web.mapper.SchoolMapper;
import com.baobei.attendance.web.mapper.StudentMapper;
import com.baobei.attendance.web.mapper.WebUserMapper;
import com.baobei.attendance.web.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    DormitoryMapper dormitoryMapper;

    @Autowired
    WebUserMapper webUserMapper;

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
        Result result;
        List<Class> classes = schoolMapper.findAllClasses();
        Map<String, Map<String, List<Class>>> departmentMap = new HashMap<>();
        for (Class clazz : classes) {
            if (!departmentMap.containsKey(clazz.getDepartmentName())) {
                departmentMap.put(clazz.getDepartmentName(), new HashMap<>());
            }
            Map<String, List<Class>> majorMap = departmentMap.get(clazz.getDepartmentName());
            if (!majorMap.containsKey(clazz.getMajorName())) {
                majorMap.put(clazz.getMajorName(), new ArrayList<>());
            }
            List<Class> classList = majorMap.get(clazz.getMajorName());
            classList.add(clazz);
        }
        List<Cascader> cascaders = new ArrayList<>();
        for (Map.Entry<String, Map<String, List<Class>>> department : departmentMap.entrySet()) {
            Cascader departmentCascader = new Cascader();
            departmentCascader.setLabel(department.getKey());
            departmentCascader.setValue(department.getKey());
            List<Cascader> majorCascaderList = new ArrayList<>();
            for (Map.Entry<String, List<Class>> major : department.getValue().entrySet()) {
                Cascader majorCascader = new Cascader();
                majorCascader.setValue(major.getKey());
                majorCascader.setLabel(major.getKey());
                List<Cascader> classCascaderList = new ArrayList<>();
                for (Class clazz : major.getValue()) {
                    Cascader classCascader = new Cascader();
                    classCascader.setValue(clazz.getId().toString());
                    classCascader.setLabel(clazz.getClassNo());
                    classCascaderList.add(classCascader);
                }
                majorCascader.setChildren(classCascaderList);
                majorCascaderList.add(majorCascader);
            }
            departmentCascader.setChildren(majorCascaderList);
            cascaders.add(departmentCascader);
        }
        Map<String, Object> data = new HashMap<>(1);
        data.put("options", cascaders);
        result = Result.retOk(data);
        return result;
    }

    @Override
    public Result getCount() {
        Result result;
        try {
            StudentSearch studentSearch = new StudentSearch();
            studentSearch.normalize();
            Integer studentCount = studentMapper.findStudentCountByCondition(studentSearch);

            WebUserSearch userSearch = new WebUserSearch();
            userSearch.normalize();
            Integer userCount = webUserMapper.findWebUserCountByCondition(userSearch);

            DormitorySearch dormSearch = new DormitorySearch();
            dormSearch.normalize();
            Integer dormCount = dormitoryMapper.findDormitoryCountByCondition(dormSearch);

            Map<String, Object> data = new HashMap<>(3);
            data.put("studentCount", studentCount);
            data.put("adminCount", userCount);
            data.put("dormitoryCount", dormCount);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }
}

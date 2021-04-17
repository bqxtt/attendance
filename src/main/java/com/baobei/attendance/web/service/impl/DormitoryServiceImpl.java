package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.entity.Dormitory;
import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.DormitorySearch;
import com.baobei.attendance.model.PageInfo;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.web.mapper.DormitoryMapper;
import com.baobei.attendance.web.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    DormitoryMapper dormitoryMapper;

    @Override
    public Result addDormitory(Dormitory dormitory) {
        Result result;
        try {
            dormitoryMapper.addDormitory(dormitory);
            Map<String, Object> data = new HashMap<>(1);
            data.put("dormitory", dormitory);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result updateDormitory(Long id, Dormitory dormitory) {
        Result result;
        if (!id.equals(dormitory.getId())) {
            result = Result.retFail("dormitory id不一致");
        } else {
            try {
                dormitoryMapper.updateDormitory(dormitory);
                Map<String, Object> data = new HashMap<>(1);
                data.put("dormitory", dormitory);
                result = Result.retOk("success", data);
            } catch (Exception e) {
                result = Result.retFail(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public Result deleteDormitory(Long id) {
        Result result;
        try {
            dormitoryMapper.deleteDormitory(id);
            result = Result.retOk("success");
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result getDormitories(DormitorySearch search) {
        Result result;
        search.normalize();
        try {
            Integer count = dormitoryMapper.findDormitoryCountByCondition(search);
            List<Dormitory> dormitories = dormitoryMapper.findDormitoriesByCondition(search);
            for (Dormitory dormitory : dormitories) {
                List<Student> students = dormitoryMapper.findDormitoryStudents(dormitory.getId());
                dormitory.setStudents(students);
            }
            PageInfo pageInfo = PageInfo.getPageInfo(count, search.getPageSize());
            Map<String, Object> data = new HashMap<>(2);
            data.put("pageInfo", pageInfo);
            data.put("dormitories", dormitories);
            result = Result.retOk("success", data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result findDormitoryById(Long id) {
        Result result;
        try {
            Dormitory dormitory = dormitoryMapper.findDormitoryById(id);
            if (dormitory != null) {
                Map<String, Object> data = new HashMap<>(1);
                data.put("dormitory", dormitory);
                result = Result.retOk("success", data);
            } else {
                result = Result.retOk("success");
            }
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result findDormitoryByRoomName(String roomName) {
        Result result;
        try {
            Dormitory dormitory = dormitoryMapper.findDormitoryByRoomName(roomName);
            if (dormitory != null) {
                Map<String, Object> data = new HashMap<>(1);
                data.put("dormitory", dormitory);
                result = Result.retOk("success", data);
            } else {
                result = Result.retOk("success");
            }
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }
}

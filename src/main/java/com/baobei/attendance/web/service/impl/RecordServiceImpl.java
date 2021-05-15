package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.entity.Record;
import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.RecordCondition;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.StudentSearch;
import com.baobei.attendance.utils.DateUtil;
import com.baobei.attendance.web.mapper.SchoolMapper;
import com.baobei.attendance.web.mapper.StudentMapper;
import com.baobei.attendance.web.mapper.WebRecordMapper;
import com.baobei.attendance.web.service.RecordService;
import com.baobei.attendance.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author tcg
 * @date 2021/5/8
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    WebRecordMapper recordMapper;

    @Autowired
    SchoolMapper schoolMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentService studentService;

    @Override
    public Result getDepartmentRecords() {
        Result result;
        try {
            List<Class> classes = schoolMapper.findAllClasses();
            Map<String, List<Long>> departmentClassIds = new HashMap<>();
            for (Class clazz : classes) {
                if (!departmentClassIds.containsKey(clazz.getDepartmentName())) {
                    departmentClassIds.put(clazz.getDepartmentName(), new ArrayList<>());
                }
                departmentClassIds.get(clazz.getDepartmentName()).add(clazz.getId());
            }
            List<String> departments = new ArrayList<>();
            List<Integer> departmentCount = new ArrayList<>();
            List<Integer> departmentRecords = new ArrayList<>();
            for (Map.Entry<String, List<Long>> entry : departmentClassIds.entrySet()) {
                departments.add(entry.getKey());
                List<Student> students = studentMapper.findStudentsByClassIds(entry.getValue());
                departmentCount.add(students.size());
                RecordCondition condition = new RecordCondition();
                condition.setClassIds(entry.getValue());
                condition.normalizeWithDate(0);
                Integer count = recordMapper.findRecordsCountByCondition(condition);
                departmentRecords.add(count);
            }
            Map<String, Object> data = new HashMap<>(3);
            data.put("departments", departments);
            data.put("studentCount", departmentCount);
            data.put("recordCount", departmentRecords);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    @Override
    public Result getRecordList(StudentSearch search) {
        Result result;
        try {
            Date now = new Date();
            result = studentService.getStudents(search);
            List<Student> students = (List<Student>) result.getData().get("students");
            if (students.size() == 0) {
                return result;
            }
            List<Long> studentIds = new ArrayList<>();
            Map<Long, Student> studentMap = new HashMap<>(students.size());
            for (Student student : students) {
                studentIds.add(student.getId());
                studentMap.put(student.getId(), student);
                student.setRecords(new Record[7]);
            }
            RecordCondition condition = new RecordCondition();
            condition.setStudentIds(studentIds);
            condition.normalizeWithDate(6);
            List<Record> records = recordMapper.findRecordsByCondition(condition);
            for (Record record : records) {
                int diffDay = DateUtil.getDiffDays(record.getRecordTime(), now);
                studentMap.get(record.getStudentId()).getRecords()[diffDay] = record;
                if (diffDay == 0) {
                    studentMap.get(record.getStudentId()).setRecordStatus(true);
                }
            }
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }
}

package com.baobei.attendance.web.mapper;

import com.baobei.attendance.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StudentMapperTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    void findStudentByStuNos() {
        List<String> nos = new ArrayList<>();
        nos.add("170950212");
        nos.add("10175101201");
        List<Student> students = studentMapper.findStudentByStuNos(nos);
        System.out.println(students);
    }
}
package com.baobei.attendance.web.service.impl;

import com.baobei.attendance.web.service.SchoolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchoolServiceImplTest {
    @Autowired
    SchoolService schoolService;

    @Test
    void getSchoolAll() {
        System.out.println(schoolService.getSchoolAll());
    }
}
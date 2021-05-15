package com.baobei.attendance.web.mapper;

import com.baobei.attendance.entity.Record;
import com.baobei.attendance.model.RecordCondition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tcg
 * @date 2021/5/13
 */
@SpringBootTest
class WebRecordMapperTest {

    @Autowired
    WebRecordMapper webRecordMapper;

    @Test
    void findRecordsByCondition() throws ParseException {
        RecordCondition search = new RecordCondition();
        List<Long> classIds = new ArrayList<>();
        classIds.add(3L);
        search.setClassIds(classIds);
        search.normalizeWithDate(7);
        System.out.println(search);
        Integer count = webRecordMapper.findRecordsCountByCondition(search);
        List<Record> records = webRecordMapper.findRecordsByCondition(search);
        System.out.println(records);
        System.out.println(count);
    }

    @Test
    void getTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.parse("2021-05-05 00:00:00"));
    }
}
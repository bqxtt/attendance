package com.baobei.attendance.web.mapper;

import com.baobei.attendance.entity.Record;
import com.baobei.attendance.model.RecordCondition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2021/5/9
 */
@Mapper
@Component
public interface WebRecordMapper {
    List<Record> findRecordsByCondition(RecordCondition condition);

    Integer findRecordsCountByCondition(RecordCondition condition);
}

package com.baobei.attendance.wechat.mapper;

import com.baobei.attendance.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/18
 */
@Mapper
@Component
public interface RecordMapper {
    /**
     * 批量添加打卡记录
     *
     * @param records
     * @return
     */
    Integer addStudentRecords(List<Record> records);
}

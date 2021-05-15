package com.baobei.attendance.web.service;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.StudentSearch;

/**
 * @author tcg
 * @date 2021/5/8
 */
public interface RecordService {
    /**
     * 获取学院打卡记录
     *
     * @return
     */
    Result getDepartmentRecords();

    /**
     * 获取记录列表
     *
     * @param search
     * @return
     */
    Result getRecordList(StudentSearch search);
}

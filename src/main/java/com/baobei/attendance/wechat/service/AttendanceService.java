package com.baobei.attendance.wechat.service;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.wechat.entity.Records;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tcg
 * @date 2021/4/18
 */
public interface AttendanceService {
    Result uploadPhoto(MultipartFile photo);

    Result addStudentRecords(Records records);

    Result queryRecord(Long studentId);

    Result samePicAdd(MultipartFile picture);

    Result samePicSearch(MultipartFile picture);
}

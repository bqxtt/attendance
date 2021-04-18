package com.baobei.attendance.wechat.service.impl;

import com.baobei.attendance.model.Result;
import com.baobei.attendance.wechat.entity.Records;
import com.baobei.attendance.wechat.service.AttendanceService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tcg
 * @date 2021/4/18
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Override
    public Result uploadPhoto(MultipartFile photo) {
        //todo
        return Result.retOk("");
    }

    @Override
    public Result addStudentRecords(Records records) {
        //todo
        return Result.retOk("");
    }
}

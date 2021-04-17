package com.baobei.attendance.web.service;

import com.baobei.attendance.entity.Dormitory;
import com.baobei.attendance.model.DormitorySearch;
import com.baobei.attendance.model.Result;

/**
 * @author tcg
 * @date 2021/4/17
 */
public interface DormitoryService {
    Result addDormitory(Dormitory dormitory);

    Result updateDormitory(Long id, Dormitory dormitory);

    Result deleteDormitory(Long id);

    Result getDormitories(DormitorySearch search);

    Result findDormitoryById(Long id);

    Result findDormitoryByRoomName(String roomName);
}

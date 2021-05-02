package com.baobei.attendance.web.service;

import com.baobei.attendance.entity.Dormitory;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.DormitorySearch;

/**
 * @author tcg
 * @date 2021/4/17
 */
public interface DormitoryService {
    /**
     * 添加宿舍
     *
     * @param dormitory
     * @return
     */
    Result addDormitory(Dormitory dormitory);

    /**
     * 修改宿舍
     *
     * @param id
     * @param dormitory
     * @return
     */
    Result updateDormitory(Long id, Dormitory dormitory);

    /**
     * 删除宿舍
     *
     * @param id
     * @return
     */
    Result deleteDormitory(Long id);

    /**
     * 获取宿舍列表
     *
     * @param search
     * @return
     */
    Result getDormitories(DormitorySearch search);

    /**
     * ID查找宿舍
     *
     * @param id
     * @return
     */
    Result findDormitoryById(Long id);

    /**
     * 标识查找宿舍
     *
     * @param roomName
     * @return
     */
    Result findDormitoryByRoomName(String roomName);

    /**
     * 添加宿舍学生
     *
     * @param dormitoryId
     * @param studentId
     * @return
     */
    Result addDormitoryStudent(Long dormitoryId, Long studentId);
}

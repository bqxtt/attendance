package com.baobei.attendance.web.mapper;

import com.baobei.attendance.entity.Dormitory;
import com.baobei.attendance.model.search.DormitorySearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Mapper
@Component
public interface DormitoryMapper {

    /**
     * 增加宿舍
     *
     * @param dormitory
     * @return
     */
    Integer addDormitory(Dormitory dormitory);

    /**
     * 修改宿舍
     *
     * @param dormitory
     * @return
     */
    Integer updateDormitory(Dormitory dormitory);

    /**
     * 删除宿舍
     *
     * @param id
     * @return
     */
    Integer deleteDormitory(Long id);

    /**
     * 查找宿舍
     *
     * @param search
     * @return
     */
    List<Dormitory> findDormitoriesByCondition(DormitorySearch search);

    /**
     * 查找数量 （分页）
     *
     * @param search
     * @return
     */
    Integer findDormitoryCountByCondition(DormitorySearch search);

    /**
     * 根据id找宿舍（唯一）
     *
     * @param dormitoryId
     * @return
     */
    Dormitory findDormitoryById(Long dormitoryId);

    /**
     * 根据名字找宿舍（唯一）
     *
     * @param roomName
     * @return
     */
    Dormitory findDormitoryByRoomName(String roomName);
}

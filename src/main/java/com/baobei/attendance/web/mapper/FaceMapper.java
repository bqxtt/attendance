package com.baobei.attendance.web.mapper;

import com.baobei.attendance.web.entity.Face;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author tcg
 * @date 2021/4/17
 */
@Mapper
@Component
public interface FaceMapper {
    Integer addOrModifyStudentFace(Face face);

    Integer deleteStudentFace(Long studentId);

    Face findFaceByStudentId(Long studentId);
}

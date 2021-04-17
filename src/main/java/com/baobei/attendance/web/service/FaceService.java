package com.baobei.attendance.web.service;

import com.baobei.attendance.model.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tcg
 * @date 2021/4/17
 */
public interface FaceService {
    /**
     * 上传人脸
     *
     * @param studentId
     * @param face
     * @return
     */
    Result uploadStudentFace(Long studentId, MultipartFile face);

    /**
     * 删除人脸
     *
     * @param studentId
     * @return
     */
    Result deleteStudentFace(Long studentId);
}

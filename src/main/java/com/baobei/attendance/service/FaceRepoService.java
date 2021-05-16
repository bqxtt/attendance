package com.baobei.attendance.service;

import com.alibaba.fastjson.JSON;
import com.baobei.attendance.ai.baidu.api.*;
import com.baobei.attendance.ai.baidu.api.entity.Brief;
import com.baobei.attendance.ai.baidu.api.entity.ImageType;
import com.baobei.attendance.ai.baidu.factory.BaiduApiFactory;
import com.baobei.attendance.config.bean.OSSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tcg
 * @date 2021/3/27
 */
@Service
public class FaceRepoService {
    private static final Logger log = LoggerFactory.getLogger(FaceRepoService.class);

    @Autowired
    private OSSClient ossClient;

    @Autowired
    private BaiduApiFactory baiduApiFactory;

    private final String groupID = "hbgc_students";


    public String uploadToOss(MultipartFile file, String filePath) throws IOException {
        String url = "";
        InputStream is;
        try {
            is = file.getInputStream();
            url = ossClient.putObject(filePath, is);
        } catch (Exception e) {
            log.error("oss put object error: ", e);
            throw e;
        }
        return url;
    }

    public String adUserFace(String userId, String url) throws Exception {
        UserAddApi api = baiduApiFactory.getUserAddApi();
        UserAddApi.UserAddReq req = new UserAddApi.UserAddReq();
        req.setUserId(userId);
        req.setImage(url);
        req.setImageType(ImageType.URL.name());
        req.setActionType(UserAddApi.UserAddReq.ActionType.REPLACE.name());
        req.setGroupId(groupID);
        UserAddApi.UserAddRes res = api.request(req);
        if (res.getErrorCode() != null && res.getErrorCode() != 0) {
            throw new Exception(res.getErrorMsg());
        }
        return res.getResult().getFaceToken();
    }

    public void deleteUserFace(String userId, String faceToken) throws Exception {
        FaceDeleteApi api = baiduApiFactory.getFaceDeleteApi();
        FaceDeleteApi.FaceDeleteReq req = new FaceDeleteApi.FaceDeleteReq();
        req.setUserId(userId);
        req.setFaceToken(faceToken);
        req.setGroupId(groupID);
        FaceDeleteApi.FaceDeleteRes res = api.request(req);
        if (res.getErrorCode() != null && res.getErrorCode() != 0) {
            throw new Exception(res.getErrorMsg());
        }
    }

    public List<String> faceMultiSearch(String url) throws Exception {
        MultiSearchApi api = baiduApiFactory.getMultiSearchApi();
        MultiSearchApi.MultiSearchReq req = new MultiSearchApi.MultiSearchReq();
        req.setGroupIdList(groupID);
        req.setImage(url);
        req.setImageType(ImageType.URL.name());
        req.setMaxFaceNum(4);
        req.setMaxUserNum(4);
        MultiSearchApi.MultiSearchRes res = api.request(req);
        if (res.getErrorCode() != null && res.getErrorCode() != 0) {
            throw new Exception(res.getErrorMsg());
        }
        MultiSearchApi.MultiSearchRes.Result result = res.getResult();
        List<MultiSearchApi.MultiSearchRes.Face> faces = result.getFaceList();
        List<String> students = new ArrayList<>();
        for (MultiSearchApi.MultiSearchRes.Face face : faces) {
            List<MultiSearchApi.MultiSearchRes.User> users = face.getUserList();
            if (users.size() == 0) {
                continue;
            }
            String studentNo = users.get(0).getUserId();
            students.add(studentNo);
        }
        return students;
    }

    public Brief samePicSearch(String url) throws Exception {
        SamePicSearchApi api = baiduApiFactory.getSamePicSearchApi();
        SamePicSearchApi.SamePicSearchReq req = new SamePicSearchApi.SamePicSearchReq();
        req.setUrl(url);
        SamePicSearchApi.SamePicSearchRes res = api.request(req);
        if (res.getErrorCode() != null && res.getErrorCode() != 0) {
            throw new Exception(res.getErrorMsg());
        }
        if (res.getResults().size() == 0) {
            return null;
        }
        Brief brief = JSON.parseObject(res.getResults().get(0).getBrief(), Brief.class);
        brief.setScore(res.getResults().get(0).getScore());
        return brief;
    }

    public void samePicAdd(String url, Brief brief) throws Exception {
        SamePicAddApi api = baiduApiFactory.getSamePicAddApi();
        SamePicAddApi.SamePicAddReq req = new SamePicAddApi.SamePicAddReq();
        req.setUrl(url);
        req.setBrief(JSON.toJSONString(brief));
        SamePicAddApi.SamePicAddRes res = api.request(req);
        if (res.getErrorCode() != null && res.getErrorCode() != 0) {
            throw new Exception(res.getErrorMsg());
        }
    }
}   

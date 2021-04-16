package com.baobei.attendance.wechat.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.baobei.attendance.config.entity.OSSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author tcg
 * @date 2021/3/27
 */
@Service
public class PhotoUploadService {
    private static final Logger log = LoggerFactory.getLogger(PhotoUploadService.class);


    @Autowired
    private OSSClient ossClient;


    public String upload(MultipartFile file) {
        long timeStamp = System.currentTimeMillis();
        String filePath = "test/" +
                timeStamp +
                getFileSuffix(Objects.requireNonNull(file.getOriginalFilename()));
        String url = "";
        InputStream is;
        try {
            is = file.getInputStream();
            url = ossClient.putObject(filePath, is);
        } catch (OSSException | ClientException | IOException e) {
            log.error("oss put object error: ", e);
            return null;
        }
        return url;
    }

    private String getFileSuffix(String fileName) {
        int begin = fileName.indexOf(".");
        return fileName.substring(begin);
    }

}   

package com.baobei.attendance.config.entity;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;

/**
 * @author tcg
 * @date 2021/3/28
 */
public class OSSClient {
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.access.key.id}")
    private String accessKeyId;
    @Value("${aliyun.oss.access.key.secret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.bucket.name}")
    private String bucketName;

    public OSS ossClient;

    void init() {
        ossClient = new OSSClientBuilder().build("https://" + endpoint, accessKeyId, accessKeySecret);
    }

    void destroy() {
        ossClient.shutdown();
    }

    public String putObject(String filePath, InputStream is) throws OSSException, ClientException {
        ossClient.putObject(bucketName, filePath, is);
        return "https://" + bucketName + "." + endpoint + "/" + filePath;
    }
}

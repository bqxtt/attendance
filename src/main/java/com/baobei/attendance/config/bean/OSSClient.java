package com.baobei.attendance.config.bean;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;

/**
 * @author tcg
 * @date 2021/3/28
 */
public class OSSClient {
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.bucket.name}")
    private String bucketName;

    public OSS ossClient;

    @Autowired
    private Config config;

    void init() {
        OSSConfig ossConfig = config.getOssConfig();
        ossClient = new OSSClientBuilder().build("https://" + endpoint, ossConfig.getOssId(), ossConfig.getOssSecret());
    }

    void destroy() {
        ossClient.shutdown();
    }

    public String putObject(String filePath, InputStream is) throws OSSException, ClientException {
        ossClient.putObject(bucketName, filePath, is);
        return "https://" + bucketName + "." + endpoint + "/" + filePath;
    }
}

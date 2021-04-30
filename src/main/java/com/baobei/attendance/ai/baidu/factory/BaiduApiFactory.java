package com.baobei.attendance.ai.baidu.factory;

import com.baobei.attendance.ai.baidu.api.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class BaiduApiFactory {
    @Autowired
    private GroupDeleteApi groupDeleteApi;
    @Autowired
    private GroupAddApi groupAddApi;
    @Autowired
    private GroupGetListApi groupGetListApi;
    @Autowired
    private MultiSearchApi multiSearchApi;
    @Autowired
    private UserAddApi userAddApi;
    @Autowired
    private FaceDeleteApi faceDeleteApi;
}

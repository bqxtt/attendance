package com.baobei.attendance.wechat.entity;

import com.baobei.attendance.entity.Record;
import lombok.Data;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/18
 */
@Data
public class Records {
    private List<Record> records;
    private String token;
}

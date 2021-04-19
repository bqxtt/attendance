package com.baobei.attendance.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author tcg
 * @date 2021/4/19
 */
@Mapper
@Component
public interface ConfigMapper {
    /**
     * 获取配置
     *
     * @param key
     * @return
     */
    @Select("select config from configs where config_key = #{key}")
    String getConfig(String key);
}

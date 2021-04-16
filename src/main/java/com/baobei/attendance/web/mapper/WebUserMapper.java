package com.baobei.attendance.web.mapper;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.web.entity.WebUser;
import com.baobei.attendance.web.entity.WebUserSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2021/3/27
 */
@Mapper
@Component("webUserMapper")
public interface WebUserMapper {
    /**
     * 查找web user
     *
     * @param account
     * @return
     */
    WebUser findWebUserByAccount(String account);

    /**
     * 查找web user
     *
     * @param webUserId
     * @return
     */
    WebUser findWebUserByWebUserId(Long webUserId);

    /**
     * 获取管理班级
     *
     * @param classIds
     * @return
     */
    List<Class> findWebUserClasses(List<Long> classIds);

    /**
     * 条件获取管理员列表
     *
     * @param search
     * @return
     */
    List<WebUser> findWebUsersByCondition(WebUserSearch search);

    /**
     * 条件获取管理员列表数量
     *
     * @param search
     * @return
     */
    Integer findWebUserCountByCondition(WebUserSearch search);

    /**
     * 增加管理员
     *
     * @param user
     * @return
     */
    Integer addWebUser(WebUser user);

    /**
     * 批量增加管理班级
     *
     * @param webUserId
     * @param classIds
     * @return
     */
    Integer addWebUserManagements(@Param("webUserId") Long webUserId, @Param("classIds") List<Long> classIds);

    /**
     * 修改管理员信息
     *
     * @param user
     * @return
     */
    Integer updateWebUser(WebUser user);

    /**
     * 删除管理班级
     *
     * @param webUserId
     * @return
     */
    Integer deleteWebUserManagements(Long webUserId);

    /**
     * 删除管理员
     *
     * @param webUserId
     * @return
     */
    Integer deleteWebUser(Long webUserId);
}

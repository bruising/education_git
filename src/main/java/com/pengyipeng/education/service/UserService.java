package com.pengyipeng.education.service;

import com.pengyipeng.education.model.entity.User_Manager;
import org.apache.ibatis.annotations.Param;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @Description:
 * @date 2020/1/4 星期六 15:52
 */
public interface UserService {
    /**
     * 通过用id和密码查询用户
     * @param userid id
     * @param pwd 密码
     * @return 用户
     */
    User_Manager getUser(@Param("userid")int userid, @Param("pwd")String pwd);

    /**
     * 添加MD5密码
     * @param userid 要添加的用户id
     * @param md5pwd md5密码
     * @return 1成功 0失败
     */
    int  updateUser(@Param("userid")int userid,@Param("md5pwd")String md5pwd);
    /**
     * 通过id获得md5密码
     * @param userid id
     * @return
     */
    String getMd5pwd(@Param("userid")int userid);
    /**
     * 通过id获得密码
     * @param userid id
     * @return
     */
    String getpwd(@Param("userid")int userid);
}

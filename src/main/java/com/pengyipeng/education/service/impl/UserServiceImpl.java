package com.pengyipeng.education.service.impl;


import com.pengyipeng.education.mapper.User_MapperDao;
import com.pengyipeng.education.model.entity.User_Manager;
import com.pengyipeng.education.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.impl
 * @Description:
 * @date 2020/1/4 星期六 15:53
 */
@Service
public class UserServiceImpl  implements UserService {

    @Resource
    private User_MapperDao user_mapperDao;
    @Override
    public User_Manager getUser(int userid, String pwd) {
        return user_mapperDao.getUser(userid, pwd);
    }

    @Override
    public int updateUser(int userid, String md5pwd) {
        return user_mapperDao.updateUser(userid, md5pwd);
    }

    @Override
    public String getMd5pwd(int userid) {
        return user_mapperDao.getMd5pwd(userid);
    }

    @Override
    public String getpwd(int userid) {
        return user_mapperDao.getpwd(userid);
    }
}

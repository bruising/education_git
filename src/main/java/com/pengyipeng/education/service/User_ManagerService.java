package com.pengyipeng.education.service;

import com.pengyipeng.education.model.entity.User_Manager;
import com.pengyipeng.education.model.vo.User_TeacherVo;
import com.pengyipeng.education.util.PageNto.PageNto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 宁坤
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper.UserManagerDao
 * @Description:用户管理的service层
 */
public interface User_ManagerService {

    /**
     * 根据用户的手机号、最近登录时间、付费状态
     * 和注册时间分页查询
     * @param phone 手机号
     * @param latest_login_time 最近登录时间
     * @param payment_status 付费状态
     * @param registration_time 最近付费时间
     * @param pageindex 当前页
     * @param pagecount  每页总条数
     * @return 用户集合
     */
    public PageNto<User_Manager> getUserByPhoneAndLogintimeAndpayment_statusAndregistration_time(
            String phone,
            String latest_login_time,
            String payment_status,
            String registration_time,
            Integer pageindex,
            Integer pagecount
    );

    /**
     * 根据用户的手机号、最近登录时间、
     * 付费状态和注册时间分页查询总条数
     * @param phone 手机号
     * @param latest_login_time 最近登录时间
     * @param payment_status 付费状态
     * @param registration_time 最近付费时间
     * @return 总条数
     */
    public int getCount(
            String phone,
            String latest_login_time,
            String payment_status,
            String registration_time
    );

    /**
     * 根据userid获取学生用户的详细信息
     * @param userid 用户ID
     * @return 学生用户集合
     */
    public List<User_Manager> getUserByUserid(Integer userid);

    /**
     * 根据userid获取教师用户的详细信息
     * @param userid 用户对象
     * @return 教师用户集合
     */
    public User_TeacherVo getTeaUserByUserid(Integer userid);
}

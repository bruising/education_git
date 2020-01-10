package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.entity.User_Manager;
import com.pengyipeng.education.model.vo.TeacherVo;
import com.pengyipeng.education.model.vo.User_TeacherVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author 宁坤
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper.UserManagerDao
 * @Description:用户管理的dao方法
 */
public interface User_ManagerDao {
    /**
     * 根据用户的手机号、最近登录时间、
     * 付费状态和注册时间分页查询
     */
    public List<User_Manager> getUserByPhoneAndLogintimeAndpayment_statusAndregistration_time(
            @Param("phone") String phone,
            @Param("latest_login_time") String latest_login_time,
            @Param("payment_status") String payment_status,
            @Param("registration_time") String registration_time,
            @Param("pageindex") Integer pageindex,
            @Param("pagecount") Integer pagecount
    );


    /**
     * 根据用户的手机号、最近登录时间、
     * 付费状态和注册时间分页查询总条数
     */
    public int getCount(
            @Param("phone") String phone,
            @Param("latest_login_time") String latest_login_time,
            @Param("payment_status") String payment_status,
            @Param("registration_time") String registration_time
    );

    //根据userid获取学生用户的详细信息
    public List<User_Manager> getUserByUserid(@Param("userid") Integer userid);

    //根据userid获取教师用户的详细信息
    public User_TeacherVo getTeaUserByUserid(@Param("userid") Integer userid);

    //查询总用户数
    public  int queryAllUserCount();


    //查询每天新增用户数
    public  int   queryAddUserEveryday();


    //查询每天新增付费用户数
    public   int  queryAddPaymentUserCountEveryday();
    //查询活跃用户数
    public   int  queryActiveUserCount();
}

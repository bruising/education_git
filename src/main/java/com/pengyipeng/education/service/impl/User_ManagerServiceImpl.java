package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.User_ManagerDao;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.entity.User_Manager;
import com.pengyipeng.education.model.vo.User_TeacherVo;
import com.pengyipeng.education.service.User_ManagerService;
import com.pengyipeng.education.util.PageNto.PageNto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author 宁坤
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper.UserManagerDao
 * @Description:用户管理的serviceImpl层
 */
@Service
public class User_ManagerServiceImpl implements User_ManagerService {

    @Resource
    private User_ManagerDao umdao;

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
    public PageNto<User_Manager> getUserByPhoneAndLogintimeAndpayment_statusAndregistration_time(String phone, String latest_login_time, String payment_status, String registration_time, Integer pageindex, Integer pagecount) {
        //获取总条数
        Integer total=this.getCount(phone, latest_login_time, payment_status, registration_time);
        //获取当前页
        Integer index=(pageindex-1)*pagecount;
        //获取当前页信息
        List<User_Manager> userList=umdao.getUserByPhoneAndLogintimeAndpayment_statusAndregistration_time(
                phone, latest_login_time, payment_status, registration_time, index, pagecount);
        //创建分页对象
        PageNto<User_Manager> userPageNto=new PageNto<>();
        //为总条数赋值
        userPageNto.setTotal((long)total);
        //为当前页赋值
        userPageNto.setPageindex(pageindex);
        //为每页的条数赋值
        userPageNto.setPagecount(pagecount);
        //为总页数赋值
        userPageNto.setPagetotal(total%pagecount==0?total/pagecount:total/pagecount+1);
        //为集合赋值
        userPageNto.setData(userList);
        return userPageNto;
    }


    /**
     * 根据用户的手机号、最近登录时间、
     * 付费状态和注册时间分页查询总条数
     * @param phone 手机号
     * @param latest_login_time 最近登录时间
     * @param payment_status 付费状态
     * @param registration_time 最近付费时间
     * @return 总条数
     */
    public int getCount(String phone, String latest_login_time, String payment_status, String registration_time) {
        return umdao.getCount(phone, latest_login_time, payment_status, registration_time);
    }

    /**
     * 根据userid获取学生用户的信息
     * @param userid 用户id
     * @return 学生用户信息集合
     */
    public List<User_Manager> getUserByUserid(Integer userid) {
        return umdao.getUserByUserid(userid);
    }


    /**
     * 根据userid获取教师用户的信息
     * @param userid 用户id
     * @return 教师用户信息对象
     */
    public User_TeacherVo getTeaUserByUserid(Integer userid) {
        return umdao.getTeaUserByUserid(userid);
    }
}

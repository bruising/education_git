package com.pengyipeng.education.service;

import com.pengyipeng.education.model.entity.StudentManagement;
import com.pengyipeng.education.model.entity.User_Manager;

import java.util.Date;
import java.util.List;

/**
 * @author 李陈
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/10 22:00 星期五
 */
public interface SupplementaryStudentService {
    /**
     * 模糊查询用户信息
     * @param ms 昵称或手机号

     * @return 用户信息
     */
    List<User_Manager> getUserByNicknameOrPhone(String ms);

    /**
     * 获取用户id对应的学生信息
     * @param userid 用户id
     * @return 学生信息
     */
    List<StudentManagement> getStudentByUserid(int userid);



    /**
     * 添加学生到对应的用户下
     * @return 添加状态
     */
    int addStudentByUserid(int userid,String sname, String birth)throws  Exception;



    /**
     * 添加补录学生的信息
     * @param course_id 课程id
     * @param sid 学生id
     * @param payment_method 支付方法
     * @param payment_price 支付金额
     * @return 添加状态
     */
    int addSupplementaryStudentByCourse_id(int course_id,int sid,String payment_method,double payment_price);

}

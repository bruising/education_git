package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.entity.StudentManagement;
import com.pengyipeng.education.model.entity.User_Manager;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author 李陈
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper
 * @date 2020/1/10 21:26 星期五
 */
/*
dao层接口（补录学生）
 */
public interface SupplementaryStudentDao {
    /**
     * 模糊查询用户信息
     * @param nickname 昵称
     * @return 用户信息
     */
    List<User_Manager> getUserByNickname(@Param("nickname")String nickname);

    /**
     * 模糊查询用户信息
     * @param phone 手机号(账号)
     * @return 用户信息
     */
    List<User_Manager> getUserByPhone(@Param("phone")String phone);

    /**
     * 获取用户id对应的学生信息
     * @param userid 用户id
     * @return 学生信息
     */
    List<StudentManagement> getStudentByUserid(@Param("userid")int userid);

    /**
     * 获取最新添加的学生sid
     * @return 学生sid
     */
    int getMaxSid();

    /**
     * 添加学生到对应的用户下
     * @return 添加状态
     */
    int addStudentByUserid(@Param("sname")String sname, @Param("age")int age, @Param("birth")Date birth);

    /**
     * 将用户和学生的关联信息添加到关联表中
     * @return 添加状态
     */
    int addUser_stu_teacher(@Param("userid")int userid,@Param("sid")int sid);

    /**
     * 添加补录学生的信息
     * @param course_id 课程id
     * @param sid 学生id
     * @param payment_method 支付方法
     * @param payment_price 支付金额
     * @return 添加状态
     */
    int addSupplementaryStudentByCourse_id(@Param("course_id")int course_id,@Param("sid")int sid,@Param("payment_method")String payment_method,@Param("payment_price")double payment_price);

}

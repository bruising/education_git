package com.pengyipeng.education.service;

import com.pengyipeng.education.model.vo.StudentVo;
import org.springframework.data.repository.query.Param;

/**
 * @author xinhai
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/8 14:39 星期三
 */
public interface StudentService {
    /**
     * 根据id查找用户
     * @param userid
     * @return
     */
    StudentVo checkStuByUserId(@Param("userid") int userid);

    /**
     * 修改学生用户信息
     * @param studentVo
     * @return
     */
    int updateInfo(StudentVo studentVo);

    /**
     * 修改手机号
     * @param userid
     * @param pwd
     * @param newPhone
     * @return
     */
    int updatePhone(int userid,String pwd,String newPhone);

    /**
     * 修改邮箱
     * @param userid
     * @param pwd
     * @param newEmail
     * @return
     */
    int updateEmail(int userid,String pwd,String newEmail);
}

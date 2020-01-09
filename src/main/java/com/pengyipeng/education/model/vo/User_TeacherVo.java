package com.pengyipeng.education.model.vo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @author编写人员 宁坤
 * @date 2020/1/9 14:43 星期四
 * @Description:用户与教师关联表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_TeacherVo {
    //用户id、教师账号状态
    private Integer userid,status;
    //用户头像，用户手机号，用户昵称，用户邮箱,用户注册时间，教师id，教师姓名，教师介绍
    private String user_photo,phone,nickname,email,registration_time,tid,tname,info;
}

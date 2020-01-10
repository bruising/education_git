package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.StudentDao;
import com.pengyipeng.education.model.vo.StudentVo;
import com.pengyipeng.education.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xinhai
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.impl
 * @date 2020/1/8 14:41 星期三
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao stud;

    @Override
    public StudentVo checkStuByUserId(int userid) {
        return stud.checkStuByUserId(userid);
    }

    @Override
    public int updateInfo(StudentVo studentVo) {
        return stud.updateInfo(studentVo);
    }

    @Override
    public int updatePhone(int userid, String pwd, String newPhone) {
        return stud.updatePhone(userid,pwd,newPhone);
    }

    @Override
    public int updateEmail(int userid, String pwd, String newEmail) {
        return stud.updateEmail(userid,pwd,newEmail);
    }
}

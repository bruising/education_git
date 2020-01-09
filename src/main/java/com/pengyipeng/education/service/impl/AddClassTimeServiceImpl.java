package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.AddCourseTime;
import com.pengyipeng.education.service.AddClassTimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.impl
 * @date 2020/1/9 19:49 星期四
 */
@Service
public class AddClassTimeServiceImpl implements AddClassTimeService {
    @Resource
    private AddCourseTime dao;
    @Override
    public int addClassTime(String courseId, String classKind , String className, String classTarget, String classVideoAddress) {
        int i = dao.addCourseTime(courseId, classKind, className, classTarget, classVideoAddress);

        return i;
    }
}

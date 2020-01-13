package com.pengyipeng.education.service.impl;


import com.pengyipeng.education.mapper.StudentInforByCourseID;
import com.pengyipeng.education.model.vo.CourseStudentUserVo;
import com.pengyipeng.education.service.CourseStudetnInforService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.impl
 * @date 2020/1/11 15:47 星期六
 */
@Service
public class CourseStudentInforServiceImpl  implements CourseStudetnInforService {

    @Resource
    private StudentInforByCourseID dao;

    @Override
    public List<CourseStudentUserVo> showStudentInforByCourseId(String courseId) {
        List<CourseStudentUserVo> courseStudentUserVos = dao.showStudendinforBycourseId(courseId);
        return courseStudentUserVos;
    }
}

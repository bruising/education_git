package com.pengyipeng.education.service;

import com.pengyipeng.education.model.vo.CourseStudentUserVo;

import java.util.List;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/11 15:45 星期六
 */
public interface CourseStudetnInforService {
    /**
     *根据课程id查询学生信息
     * @param courseId
     * @return
     */
    List<CourseStudentUserVo> showStudentInforByCourseId(String courseId);
}
